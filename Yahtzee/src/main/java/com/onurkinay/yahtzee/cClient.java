/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onurkinay.yahtzee;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author k-sam
 */
//<editor-fold defaultstate="collapsed" desc="cClient sınıfı">
public class cClient {

    public Socket socket;
    public ObjectInputStream cInput;
    public ObjectOutputStream cOutput;
    public boolean isConnected;
    public String serverIP;
    public int serverPort;
    public ClientListenThread listenThread;

    public cClient(String serverIp, int serverPort) {
        try {

            this.isConnected = false;
            this.serverIP = serverIp;
            this.serverPort = serverPort;
            this.socket = new Socket(this.serverIP, this.serverPort);
            this.cOutput = new ObjectOutputStream(this.socket.getOutputStream());
            this.cInput = new ObjectInputStream(this.socket.getInputStream());
             main.panel.sunucuVarmi = true;
        } catch (java.net.ConnectException e) {
              main.panel.sunucuVarmi = false;
             
            
            
        } catch (IOException ex) {
            Logger.getLogger(cClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SendMessage(Object msg) {
        if (this.socket.isConnected()) {
            try {
                cOutput.writeObject(msg);
            } catch (IOException ex) {
                Logger.getLogger(cClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Start() {

        this.listenThread = new ClientListenThread(this);
        this.isConnected = true;
        this.listenThread.start();
    }

    public void Close() {
        try {
            this.isConnected = false;
            this.socket.close();
            this.cInput.close();
            this.cOutput.close();
        } catch (IOException ex) {
            Logger.getLogger(cClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
//</editor-fold>

class ClientListenThread extends Thread {

    private cClient client;

    public ClientListenThread(cClient client) {
        this.client = client;

    }

    @Override
    public void run() {
        while (this.client.isConnected) {
            try {//Serverdan gelen mesajlar

                Object msg = this.client.cInput.readObject(); // blocking method | waiting message
                System.out.println(msg.toString());
                //<editor-fold defaultstate="collapsed" desc="hareketler">
                if (msg.toString().contains("foundPlayer")) {//maç eşleştirme sistemi
                    String[] player = msg.toString().substring(13).split("#");
                    main.panel.enemy = Integer.parseInt(player[0]);

                    if (msg.toString().contains("foundPlayerT")) {//ilk kim başlıyor??
                        main.panel.start(true, player[1]);
                        main.panel.oyunTur = -1;
                    } else if (msg.toString().contains("foundPlayerF")) {
                        main.panel.start(false, player[1]);
                        main.panel.oyunTur = 0;
                    }
                    main.panel.findAMatch.getAccessibleContext().setAccessibleDescription("terket");
                    main.panel.connectServer.setEnabled(false);
                } else if (msg.toString().contains("e#ZarAt")) {

                    System.out.println("düşman zar atti");

                    main.panel.zarlariAt(2);

                } else if (msg.toString().contains("DusmanZarlar")) {

                    System.out.println("düşman zarlari geldi");
                    String s = msg.toString();
                    String zarlar = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
                    
                    main.panel.zarlariDuzenle(zarlar);

                } else if (msg.toString().contains("ZarAl")) {

                    System.out.println("düşman zar alma hareketi yapti");
                    String s = msg.toString();
                    String zar = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
                    main.panel.zarIsleri(zar + "-" + "1");

                } else if (msg.toString().contains("ZarVer")) {

                    System.out.println("düşman zar verme haretketi yapti");
                    String s = msg.toString();
                    String zar = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
                    main.panel.zarIsleri(zar + "-" + "2");

                } else if (msg.toString().contains("myturn")) {

                    System.out.println("sıra bende");
                    String s = msg.toString();
                    int secilen = Integer.parseInt(s.substring(s.indexOf("[") + 1, s.indexOf("]")));
                    if (secilen != 17) {
                        if( main.panel.gameCard.getValueAt(secilen, 2) != null ){
                        main.panel.gameCard.setValueAt("*" + main.panel.gameCard.getValueAt(secilen, 2).toString(), secilen, 2);
                        }else{
                            main.panel.gameCard.setValueAt("*0", secilen, 2);
                        }
                    }
                    System.out.println("secilen puan geldi");


                    main.panel.zarAt.setEnabled(true);
                    main.panel.turn = true;
                    main.panel.tur = 0;

                    main.panel.tabloTemizle();
                    main.panel.calculateScore(2);

                    main.panel.jLabel9.setText("Your turn!");
                    main.panel.jLabel7.setText("Yeni raund");
                     
                    main.panel.restartDice();

                } else if (msg.toString().contains("macBitir")) {
                    main.panel.finishMatch();
                } else if (msg.toString().contains("quit_the_match")) {
                    main.panel.quittedMatch();
                   

                }
//</editor-fold>

            } catch (IOException ex) {
                this.client.Close();
                Logger.getLogger(ClientListenThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                this.client.Close();
                Logger.getLogger(ClientListenThread.class.getName()).log(Level.SEVERE, null, ex);

            } catch (InterruptedException ex) {
                Logger.getLogger(ClientListenThread.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}

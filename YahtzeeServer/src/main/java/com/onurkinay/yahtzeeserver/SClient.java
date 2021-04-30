/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onurkinay.yahtzeeserver;

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
//<editor-fold defaultstate="collapsed" desc="SClient Sınıfı">
public class SClient {

    public static int idCount;
    public Server server;
    public int id;
    public Socket socket;
    public ObjectOutputStream cOutput;
    public ObjectInputStream cInput;
    public ClientListenThread listenThread;
    public boolean isConnected;
    public String nickName = "";

    public SClient(Socket socket, Server server) {
        try {
            this.server = server;
            this.id = idCount;
            idCount++;
            this.socket = socket;
            this.cOutput = new ObjectOutputStream(this.socket.getOutputStream());
            this.cInput = new ObjectInputStream(this.socket.getInputStream());
            this.nickName = "waiting a nickname";

            this.listenThread = new ClientListenThread(this);
            System.out.println("client connected");
            this.isConnected = false;
        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Close() {
        try {
            this.isConnected = false;
            this.socket.close();
            this.cInput.close();
            this.cOutput.close();
        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void SendMessage(Object msg) {
        if (this.socket.isConnected()) {
            try {
                cOutput.writeObject(msg);
            } catch (IOException ex) {
                Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Listen() {

        this.isConnected = true;
        this.listenThread.start();
        System.out.println("client listening");
    }

}
//</editor-fold>

class ClientListenThread extends Thread {

    private SClient client;

    public ClientListenThread(SClient client) {
        this.client = client;

    }

    @Override
    public void run() {
        while (this.client.isConnected) {
            try {
                System.out.println("waiting message from client");
                Object msg = this.client.cInput.readObject(); // blocking method | waiting message
                System.out.println(msg.toString());
                //<editor-fold defaultstate="collapsed" desc="hareketler">
                if (msg.toString().contains("match_me")) {

                    boolean bulundu = false;
                    String s = msg.toString();
                    String playerName = s.substring(s.indexOf("<") + 1, s.indexOf(">"));
                    this.client.nickName = playerName;
                    for (Match mac : FrmServer.maclar) {
                        if (mac.player2 == -1) {
                            mac.player2 = this.client.id;
                            mac.player2Name = playerName;
                            FrmServer.clientMessagesModel.addElement("Match#" + mac.id + " Players: " + mac.player1Name + " <-> " + mac.player2Name);

                            this.client.SendMessage("foundPlayerF#" + mac.player1 + "#" + mac.player1Name);
                            FrmServer.myserver.SendSelectedClientMessage("foundPlayerT#" + mac.player2 + "#" + mac.player2Name, mac.player1);
                            bulundu = true;
                            break;
                        }
                    }

                    if (!bulundu) {
                        Match yeniMac = new Match(this.client.id, playerName);
                        FrmServer.maclar.add(yeniMac);
                    }

                } else if (msg.toString().contains("register_me")) {
                    String s = msg.toString();
                    String playerName = s.substring(s.indexOf("<") + 1, s.indexOf(">"));
                    this.client.nickName = playerName;
                    FrmServer.myserver.UpdateClientList();
                } else if (msg.toString().contains("quit_for_search")) {
                    Match silinecekMac = null;
                    for (Match mac : FrmServer.maclar) {
                        if (mac.player2 == -1) {
                            if (mac.player1 == this.client.id) {
                                silinecekMac = mac;
                                System.out.println(mac.id + " is aborted when searching");
                                break;
                            }
                        }
                    }
                    FrmServer.maclar.remove(silinecekMac);

                } else {
                    if (msg.toString().contains("e#zarAt")) {

                        System.out.println("oyunculardan biri hareketini yaptı");
                        String s = msg.toString();
                        int pEnemy = Integer.parseInt(s.substring(s.indexOf("{") + 1, s.indexOf("}")));
                        FrmServer.myserver.SendSelectedClientMessage("e#ZarAt", pEnemy);

                    } else if (msg.toString().contains("GelenZarlar")) {

                        System.out.println("oyunculardan biri hareketini yaptı");
                        String s = msg.toString();
                        int pEnemy = Integer.parseInt(s.substring(s.indexOf("{") + 1, s.indexOf("}")));

                        String zarlar = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
                        FrmServer.myserver.SendSelectedClientMessage("DusmanZarlar[" + zarlar + "]", pEnemy);

                    } else if (msg.toString().contains("ZarAl")) {

                        System.out.println("oyunculardan biri zar aldı");
                        String s = msg.toString();
                        int pEnemy = Integer.parseInt(s.substring(s.indexOf("{") + 1, s.indexOf("}")));

                        String zar = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
                        FrmServer.myserver.SendSelectedClientMessage("ZarAl[" + zar + "]", pEnemy);

                    } else if (msg.toString().contains("ZarVer")) {

                        System.out.println("oyunculardan biri zar verdi");
                        String s = msg.toString();
                        int pEnemy = Integer.parseInt(s.substring(s.indexOf("{") + 1, s.indexOf("}")));

                        String zar = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
                        FrmServer.myserver.SendSelectedClientMessage("ZarVer[" + zar + "]", pEnemy);

                    } else if (msg.toString().contains("yourTurn")) {
                        System.out.println("sıra baskasinda");
                        String s = msg.toString();
                        String secilen = s.substring(s.indexOf("[") + 1, s.indexOf("]"));
                        int pEnemy = Integer.parseInt(s.substring(s.indexOf("{") + 1, s.indexOf("}")));

                        FrmServer.myserver.SendSelectedClientMessage("myturn[" + secilen + "]", pEnemy);
                    } else if (msg.toString().contains("macBitir")) {
                        System.out.println("mac bitti");
                        String s = msg.toString();
                        int pEnemy = Integer.parseInt(s.substring(s.indexOf("{") + 1, s.indexOf("}")));

                        FrmServer.myserver.SendSelectedClientMessage("macBitir", pEnemy);

                        Match silinecekMac = null;
                        for (Match mac : FrmServer.maclar) {
                            if (mac.player2 == pEnemy && mac.player1 == this.client.id) {
                                silinecekMac = mac;
                                System.out.println(mac.id + " is finished");
                                break;
                            }
                        }
                        FrmServer.maclar.remove(silinecekMac);

                    } else if (msg.toString().contains("quit_the_match")) {
                        System.out.println("mac erken bitti");
                        String s = msg.toString();
                        int pEnemy = Integer.parseInt(s.substring(s.indexOf("{") + 1, s.indexOf("}")));

                        FrmServer.myserver.SendSelectedClientMessage("quit_the_match", pEnemy);

                        Match silinecekMac = null;
                        for (Match mac : FrmServer.maclar) {
                            if (mac.player2 == pEnemy && mac.player1 == this.client.id) {
                                silinecekMac = mac;
                                System.out.println(mac.id + " is finished");
                                break;
                            }
                        }
                        FrmServer.maclar.remove(silinecekMac);
                    }
//</editor-fold>

                }

            } catch (IOException ex) {
                this.client.server.RemoveClient(client);
                Logger.getLogger(ClientListenThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                this.client.server.RemoveClient(client);
                Logger.getLogger(ClientListenThread.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}

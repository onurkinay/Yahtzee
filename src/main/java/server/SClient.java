/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author onur
 */
public class SClient {
    public static int idCount;
    public int id;
    public Socket socket;
    public ObjectOutputStream cOutput;
    public ObjectInputStream cInput;
    public ClientListenThread listenThread;

    public SClient(Socket socket) {
        try {
            this.id=idCount;
            idCount++;
            this.socket = socket;
            this.cOutput = new ObjectOutputStream(this.socket.getOutputStream());
            this.cInput = new ObjectInputStream(this.socket.getInputStream());
            
            this.listenThread = new ClientListenThread(this);
            System.out.println("client connected");
            SendMessage("id:"+this.id);
            
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

        this.listenThread.start();
        System.out.println("client listening");
    }

}

class ClientListenThread extends Thread {

    private SClient client;

    public ClientListenThread(SClient client) {
        this.client = client;

    }

    @Override
    public void run() {
        while (!this.client.socket.isClosed()) {
            try {
                System.out.println("waiting message from client");
                Object msg = this.client.cInput.readObject(); // blocking method | waiting message
                System.out.println(msg.toString());
                FrmServer.clientMessagesModel.addElement("player_id="+this.client.id);
                
                if(msg.toString().equals("match_newGame")){
                    if(this.client.id == 0) this.client.SendMessage("waitForPlayer");
                    else this.client.SendMessage("your_enemy:"+this.client.id);
                } 

            } catch (IOException ex) {
                Logger.getLogger(ClientListenThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientListenThread.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}

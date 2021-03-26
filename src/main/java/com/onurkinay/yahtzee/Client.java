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
 * @author onur
 */
public class Client {

    public Socket socket;
    public ObjectInputStream cInput;
    public ObjectOutputStream cOutput;

    public String serverIP;
    public int serverPort;

    public String Connect(String serverIp, int serverPort) {
        try {
            this.serverIP = serverIp;
            this.serverPort = serverPort;
            System.out.println("connecting");
            this.socket = new Socket(this.serverIP, this.serverPort);
            System.out.println("connected");
            this.cOutput = new ObjectOutputStream(this.socket.getOutputStream());
            this.cInput = new ObjectInputStream(this.socket.getInputStream());

            this.cOutput.writeObject("match_newGame");

            Object msg = cInput.readObject();
            return msg.toString();

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "-1";
    }

}

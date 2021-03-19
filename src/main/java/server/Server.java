/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author onur
 */
public class Server {

    public ServerSocket socket;
    public int port;

    public Server(int port) {
        try {
            this.port = port;
            this.socket = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void Listen() {
        while (!this.socket.isClosed()) {
            try {
                System.out.println("listening...");
                Socket nClient = this.socket.accept();
                System.out.println("client connected");

                ObjectOutputStream cOutput = new ObjectOutputStream(nClient.getOutputStream());
                ObjectInputStream cInput = new ObjectInputStream(nClient.getInputStream());

                Object msg = cInput.readObject();
                System.out.println(msg.toString());

                cOutput.writeObject("welcome");

            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

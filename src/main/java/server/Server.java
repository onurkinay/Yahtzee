/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

///NO CHANGE REALLY FOR NOW
package server;

 
import java.io.IOException; 
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger; 

/**
 *
 * @author k-sam
 */
public class Server {
    
    public ServerSocket socket;
    public ListenThread listenThread;
    public int port;
    public ArrayList<SClient> clients;
    
    public Server(int port) {
        try {
            
            this.port = port;
            this.socket = new ServerSocket(port);// statik ip var
            this.clients = new ArrayList<SClient>();
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Listen() {
        this.listenThread = new ListenThread(this);
        this.listenThread.start();
    }
    
    public void SendBroadcastMessage(Object msg) {
        for (SClient client : clients) {
            client.SendMessage(msg);
        }
    }
    
    public void SendSelectedClientMessage(Object msg, int id) {
        for (SClient client : clients) {
            if (id == client.id) {
                client.SendMessage(msg);
                break;
            }
        }
    }
    
    

    public void RemoveClient(SClient client) {
        for (int i = 0; i < this.clients.size(); i++) {
            if (this.clients.get(i).id == client.id) {
                this.clients.get(i).Close();
                this.clients.remove(i);
                break;
            }
        }
        this.UpdateClientList();
    }
    
    public void UpdateClientList() {
        FrmServer.clientsConnectedModel.removeAllElements();
        for (SClient client : clients) {
            FrmServer.clientsConnectedModel.addElement(client.id);
        }
        
    }
    
    public void MessageReceived(Object msg)
    {
        FrmServer.clientMessagesModel.addElement(msg.toString());
    }
    
}

class ListenThread extends Thread {
    
    private Server server;
    
    public ListenThread(Server server) {
        
        this.server = server;
        
    }
    
    @Override
    public void run() {
        while (!this.server.socket.isClosed()) {
            try {
                
                System.out.println("listening");
                Socket nSocket = this.server.socket.accept();//blocking method | soket döndürür ip + port

                SClient nClient = new SClient(nSocket, this.server);
                nClient.Listen();
                this.server.clients.add(nClient);
                FrmServer.clientsConnectedModel.addElement(Integer.toString(nClient.id));
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}

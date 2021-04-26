/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onurkinay.yahtzeeserver;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author k-sam
 */
public class RunMain {
    
    public static void main(String[] args) {
        Server myServer= new Server(5000);
        myServer.Listen();
    
        while (true) {            
            System.out.println("buradayım");
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RunMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
        
    }
}

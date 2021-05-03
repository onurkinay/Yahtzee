/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onurkinay.yahtzeeserver;

/**
 *
 * @author onur
 */
public class Match {
    static int idK = 0;
    int id;
    int player1;
    int player2; 
    
    String player1Name = "";
    String player2Name = "";
     
     

    public Match(int player1, String player1Name) {
        this.id = idK++;
        this.player1 = player1;
        this.player1Name = player1Name;
        this.player2 = -1;
        
    }
    public void foundEnemy(int player2, String name){
        this.player2 = player2;
        this.player2Name = name;
    }
}

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

    public Match(int player1) {
        this.id = idK++;
        this.player1 = player1;
        this.player2 = -1;
        
    }
    public void foundEnemy(int player2){
        this.player2 = player2;
    }
}

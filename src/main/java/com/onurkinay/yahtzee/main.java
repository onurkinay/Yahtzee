/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onurkinay.yahtzee;

/**
 *
 * @author onur
 */
public class main {

    public static void main(String[] args) {
        System.out.println("Let's start!!!!");
        Client myClient = new Client();
        myClient.Connect("127.0.0.1", 5000);
    }
}

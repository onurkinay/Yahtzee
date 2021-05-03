/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onurkinay.yahtzeeserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author k-sam
 */
public class FrmServer extends javax.swing.JFrame {

    public static Server myserver;
    public static ArrayList<Match> maclar = new ArrayList<>();
    public static DefaultListModel maclarModel;
    public static DefaultListModel clientsConnectedModel;

    /**
     * Creates new form FrmServer
     */
    public FrmServer() {
        initComponents();

        maclarModel = new DefaultListModel();
        lst_maclar.setModel(maclarModel);
        clientsConnectedModel = new DefaultListModel();
        lst_clientsConnected.setModel(clientsConnectedModel);

        setTitle("Yahtzee Server");
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_start = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_maclar = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lst_clientsConnected = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_start.setText("Start");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        getContentPane().add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, -1));

        lst_maclar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lst_maclarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lst_maclar);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 290, 360));

        jScrollPane3.setViewportView(lst_clientsConnected);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        // TODO add your handling code here:
        if (btn_start.getText().equals("Start")) {
            this.myserver = new Server(5000);
            this.myserver.Listen();
            setTitle("SERVER IS RUNNING - Yahtzee");
            btn_start.setText("Stop");
        } else {
            try {
                myserver.SendBroadcastMessage("server-is-closed");
                myserver.socket.close();
                myserver.socket = null;
            } catch (IOException ex) {
                Logger.getLogger(FrmServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.myserver = null;
            setTitle("SERVER IS STOPPED - Yahtzee");

            btn_start.setText("Start");
        }
        //stop code
    }//GEN-LAST:event_btn_startActionPerformed

    private void lst_maclarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lst_maclarMouseClicked

    }//GEN-LAST:event_lst_maclarMouseClicked
 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_start;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> lst_clientsConnected;
    private javax.swing.JList<String> lst_maclar;
    // End of variables declaration//GEN-END:variables
}

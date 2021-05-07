/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onurkinay.yahtzee;

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

/**
 *
 * @author onur
 */
public class ServerDialog extends JDialog implements ActionListener {

    private String[] data;
    private JTextField serverIP;
    private JCheckBox resmiKullan;
    private JComboBox<String> resmi;
    private JButton btnOk;
    private JButton btnCancel;

    public ServerDialog(Frame parent) {

        super(parent, "Server giriniz", true);
        setResizable(false);
        String[] resmiServerlar = {"us-yahtzee.onurkinay.com.tr","eu-yahtzee.onurkinay.com.tr" ,"127.0.0.1"};

        Point loc = parent.getLocation();
        setLocation(loc.x + 180, loc.y + 180);
        data = new String[1];
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel serverLabel = new JLabel("Enter server:");
        serverIP = new JTextField(15);
        resmiKullan = new JCheckBox("Use offical servers");
        btnOk = new JButton("Ok");
        btnCancel = new JButton("Cancel");
        resmi = new JComboBox<String>(resmiServerlar);
        resmi.setVisible(false);

        panel.add(serverLabel);
        panel.add(serverIP);
        panel.add(resmiKullan);
        panel.add(resmi);
        panel.add(btnOk);
        panel.add(btnCancel);

        serverLabel.setBounds(5, 10, 85, 25);
        resmi.setBounds(90, 10, 265, 25);
        serverIP.setBounds(90, 10, 265, 25);
        btnOk.setBounds(155, 70, 95, 25);
        btnCancel.setBounds(255, 70, 100, 25);
        resmiKullan.setBounds(90, 40, 265, 25);

        btnOk.addActionListener(this);

        btnCancel.addActionListener(this);

        panel.setPreferredSize(new Dimension(364, 101));
        getContentPane().add(panel);
        pack();

        resmiKullan.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
                resmi.setVisible(true);
                resmi.setEnabled(true);

                serverIP.setVisible(false);
                serverIP.setEnabled(false);
            } else {//checkbox has been deselected
                resmi.setVisible(false);
                resmi.setEnabled(false);

                serverIP.setVisible(true);
                serverIP.setEnabled(true);
            };
        });
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == btnOk) {
            if (serverIP.isVisible() && serverIP.getText().length() > 0) {
                data[0] = serverIP.getText();
            } else if (resmi.isVisible()) {
                data[0] = resmi.getSelectedItem().toString();
            }

        } else {
            data[0] = null;
        }
        dispose();
    }

    public String[] run() {
        this.setVisible(true);
        return data;
    }
}

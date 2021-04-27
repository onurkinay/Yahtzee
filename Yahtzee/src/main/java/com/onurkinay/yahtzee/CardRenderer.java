/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onurkinay.yahtzee;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author onur
 */
public class CardRenderer extends JLabel implements TableCellRenderer {

    public CardRenderer() {
        super.setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (column == 0) {
            super.setHorizontalAlignment(JLabel.CENTER);
            if (row == 6 || row == 7 || row == 8 || row == 9 || row == 21 || row == 20 || row == 19 || row == 18) {
                super.setBackground(Color.RED);
            } else {
                super.setBackground(Color.GREEN);
            }
        } else {
            super.setBackground(Color.WHITE);
            super.setHorizontalAlignment(JLabel.RIGHT);

        }

        if (value == null) {
            super.setText("");
        } else {

            if ("*".equals(value.toString().substring(0, 1))) {
                if (column == 2) {
                    super.setBackground(Color.ORANGE);

                } else if (column == 1) {
                    super.setBackground(Color.magenta);
                }
            }
            super.setText(value.toString());
        }

        if (column == 1 && row == main.panel.rollOverRowIndex) {
            super.setBackground(Color.BLUE);
        } else {

        }
        if(value != null){
        if(main.panel.secilen == row && column == 1 && !"*".equals(value.toString().substring(0, 1))){
             super.setBackground(Color.PINK);
        }else{
             
        }
        } 
        

        return this;
    }
}

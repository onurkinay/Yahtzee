/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onurkinay.yahtzee;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author onur
 */
public class Game extends javax.swing.JFrame {

    /**
     * Creates new form Game
     */
    public DefaultListModel clientMessagesModel;
    cClient myClient = null;
    public int enemy = -2;
    public boolean turn = false;
    int tur = 0;
    int secilen = -1;
    public Game() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gameCard = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        acceptBtn = new javax.swing.JButton();
        zarAt = new javax.swing.JButton();
        orta = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        oyuncu = new javax.swing.JPanel();
        rakip = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        connectServer = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gameCard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Ones", null, null},
                {"Two", null, null},
                {"Threes", null, null},
                {"Fours", null, null},
                {"Fives", null, null},
                {"Sixes", null, null},
                {null, null, null},
                {"Sum", null, null},
                {"Bonus", null, null},
                {null, null, null},
                {"Three of a kind", null, null},
                {"Four of a kind", null, null},
                {"Full House", null, null},
                {"Small straight", null, null},
                {"Large straight", null, null},
                {"Chance", null, null},
                {"YAHTZEE", null, null}
            },
            new String [] {
                "", "You", "Enemy"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        gameCard.setEnabled(false);
        gameCard.setShowGrid(true);
        gameCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gameCardMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gameCard);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 289, 311));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, -1, -1));

        acceptBtn.setText("Accept");
        acceptBtn.setEnabled(false);
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });
        getContentPane().add(acceptBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, 289, -1));

        zarAt.setText("Roll Dice");
        zarAt.setEnabled(false);
        zarAt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zarAtActionPerformed(evt);
            }
        });
        getContentPane().add(zarAt, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 552, 600, -1));

        orta.setBackground(new java.awt.Color(0, 204, 204));
        orta.setName("orta"); // NOI18N
        orta.setLayout(null);

        jLabel2.setText("ss");
        jLabel2.setMaximumSize(new java.awt.Dimension(253, 236));
        jLabel2.setMinimumSize(new java.awt.Dimension(253, 236));
        jLabel2.setPreferredSize(new java.awt.Dimension(50, 50));
        orta.add(jLabel2);
        jLabel2.setBounds(140, 30, 50, 50);
        jLabel2.getAccessibleContext().setAccessibleName("zar1");

        jLabel3.setText("ss");
        jLabel3.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel3.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel3.setPreferredSize(new java.awt.Dimension(50, 50));
        orta.add(jLabel3);
        jLabel3.setBounds(200, 30, 50, 50);
        jLabel3.getAccessibleContext().setAccessibleName("zar2");

        jLabel4.setText("ss");
        jLabel4.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel4.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel4.setPreferredSize(new java.awt.Dimension(50, 50));
        orta.add(jLabel4);
        jLabel4.setBounds(260, 30, 50, 50);
        jLabel4.getAccessibleContext().setAccessibleName("zar3");

        jLabel5.setText("ss");
        jLabel5.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel5.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel5.setPreferredSize(new java.awt.Dimension(50, 50));
        orta.add(jLabel5);
        jLabel5.setBounds(320, 30, 50, 50);
        jLabel5.getAccessibleContext().setAccessibleName("zar4");

        jLabel6.setText("ss");
        jLabel6.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel6.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel6.setPreferredSize(new java.awt.Dimension(50, 50));
        orta.add(jLabel6);
        jLabel6.setBounds(380, 30, 50, 50);
        jLabel6.getAccessibleContext().setAccessibleName("zar5");

        getContentPane().add(orta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 600, 120));

        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, -1, -1));

        oyuncu.setBackground(new java.awt.Color(204, 0, 183));
        oyuncu.setName("orta"); // NOI18N
        oyuncu.setLayout(null);
        getContentPane().add(oyuncu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 600, 120));

        rakip.setBackground(new java.awt.Color(51, 255, 0));
        rakip.setName("orta"); // NOI18N
        rakip.setLayout(null);
        getContentPane().add(rakip, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 600, 120));

        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, -1, -1));

        connectServer.setText("Connect and Find a match");
        connectServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectServerActionPerformed(evt);
            }
        });
        getContentPane().add(connectServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, 290, -1));

        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void gameCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameCardMouseClicked
        // TODO add your handling code here:
        int row = gameCard.rowAtPoint(evt.getPoint());

        int col = gameCard.columnAtPoint(evt.getPoint());
        if (row == 6 || row == 7 || row == 8 || row == 9) {
            jLabel1.setText("Hatalı Seçim");
            secilen = -1;
        } else {
            // jLabel1.setText("" + jTable1.getValueAt(row, 0).toString() + " of Player #" + col);
            jLabel1.setText("" + gameCard.getValueAt(row, 0).toString() + " seçildi");
            secilen = row;
        }

    }//GEN-LAST:event_gameCardMouseClicked

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        if (secilen != -1) {
            gameCard.setValueAt("*" + gameCard.getValueAt(secilen, 1).toString(), secilen, 1);
            tur = 0;
            zarAt.setEnabled(true);
            for (Component zar : oyuncu.getComponents()) {

                zar.setLocation(zar.getLocation().x, 30);
                zar.removeMouseListener(ortaZarMouse);
                zar.removeMouseListener(oyuncuZarMouse);

                // zar.addMouseListener(oyuncuZarMouse);
                oyuncu.remove(zar);
                orta.add(zar);

                refresh();

            }
            jLabel7.setText("Yeni raund");

            zarAt.setEnabled(false);
            acceptBtn.setEnabled(false);
            JLabel[] images = new JLabel[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6};

            for (JLabel img : images) {

                img.removeMouseListener(oyuncuZarMouse);
                img.removeMouseListener(ortaZarMouse);

            }
            mesajlas("yourTurn");
        } else {
            //herhangi bir seçim yapılmadı
            jLabel1.setText("Herhangi bir seçim yapılmadı");
        }
    }//GEN-LAST:event_acceptBtnActionPerformed
   
    private void zarAtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zarAtActionPerformed

        mesajlas("e#zarAt");
        zarlariAt(1);

    }//GEN-LAST:event_zarAtActionPerformed

    private void connectServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectServerActionPerformed
        // TODO add your handling code here:

        if (myClient == null) {
            myClient = new cClient("127.0.0.1", 5000);
            myClient.Start();

            mesajlas("match_me");
            jLabel8.setText("Connected and waiting a enemy");
            connectServer.setEnabled(false);
        } else if (!myClient.isConnected) {
            myClient.Start();
        }
    }//GEN-LAST:event_connectServerActionPerformed
    //<editor-fold defaultstate="collapsed" desc="rastgele zar atar">
    public void zarlariAt(int player) {
        
        if (tur < 3) {
            tur++;
            /*   for (Component gelenler : oyuncu.getComponents()) {
            if (gelenler instanceof JLabel) {
            gelenler.removeMouseListener(ortaZarMouse);
            gelenler.removeMouseListener(oyuncuZarMouse);
            }
            }*/
            
            String[] dice = new String[]{"", "one", "two", "three", "four", "five", "six"};
            ArrayList<JLabel> zarlar = new ArrayList<>();
            for (Component gelenler : orta.getComponents()) {
                if (gelenler instanceof JLabel) {
                    zarlar.add((JLabel) gelenler);
                }
            }
            
            int delay = 0; // delay for 5 sec.
            int period = 100; // repeat every sec.
            Timer timer = new Timer();
            
            timer.scheduleAtFixedRate(new TimerTask() {
                int i = 0;
                
                public void run() {
                    for (JLabel img : zarlar) {
                        img.setText("");
                        
                        if (turn) {
                            img.addMouseListener(oyuncuZarMouse);
                        }
                        
                        int k = 1 + (int) (Math.random() * ((5) + 1));
                        ImageIcon icon = new ImageIcon("dice/" + dice[k] + ".jpg");
                        Image image = icon.getImage();
                        Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
                        img.setIcon(new ImageIcon(newimg));
                        img.getAccessibleContext().setAccessibleDescription("" + k);
                        
                    }
                    i++;
                    if (i >= 10) {
                        
                        timer.cancel();
                        mesajlas("GelenZarlar[" + gelenZarlar() + "]");
                        Calculate(player);
                        if (tur >= 3) {
                            jLabel7.setText("Tur sayısı bitti");
                            zarAt.setEnabled(false);
                            if (turn) {
                                
                                acceptBtn.setEnabled(true);
                                for (Component img : zarlar) {
                                    
                                    img.setLocation(img.getLocation().x, 30);
                                    img.removeMouseListener(oyuncuZarMouse);
                                    img.removeMouseListener(ortaZarMouse);
                                    
                                    img.addMouseListener(ortaZarMouse);
                                    
                                    orta.remove(img);
                                    oyuncu.add(img);
                                    
                                    refresh();
                                }
                                
                                for (Component gelenler : oyuncu.getComponents()) {
                                    if (gelenler instanceof JLabel) {
                                        gelenler.removeMouseListener(ortaZarMouse);
                                        gelenler.removeMouseListener(oyuncuZarMouse);
                                    }
                                }
                            } else {
                                
                                acceptBtn.setEnabled(false);
                                for (Component img : zarlar) {
                                    
                                    img.setLocation(img.getLocation().x, 30);
                                    img.removeMouseListener(oyuncuZarMouse);
                                    img.removeMouseListener(ortaZarMouse);
                                    
                                    orta.remove(img);
                                    rakip.add(img);
                                    
                                    refresh();
                                }
                                
                                for (Component gelenler : rakip.getComponents()) {
                                    if (gelenler instanceof JLabel) {
                                        gelenler.removeMouseListener(ortaZarMouse);
                                        gelenler.removeMouseListener(oyuncuZarMouse);
                                    }
                                }
                            }
                        }
                    }
                }
            }, delay, period);
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="aldığı parametreye göre zar hareketi yapar">
    void zarIsleri(String s) {
        if ((s != null)) {
            // 1-1 -> zar sırası - 1-zarı al/2-zarı geri at/3-roll
            JLabel[] images = new JLabel[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6};
            
            int zarSirasi = Integer.parseInt(s.substring(0, 1)) - 1;
            JLabel zar = images[zarSirasi];
            
            int komut = Integer.parseInt(s.substring(2, 3));
            
            switch (komut) {
                case 1:
                    zar.setLocation(zar.getLocation().x, 31);
                    zar.removeMouseListener(oyuncuZarMouse);
                    zar.removeMouseListener(ortaZarMouse);
                    orta.remove(zar);
                    rakip.add(zar);
                    refresh();
                    break;
                case 2:
                    zar.setLocation(zar.getLocation().x, 30);
                    zar.removeMouseListener(ortaZarMouse);
                    zar.removeMouseListener(oyuncuZarMouse);
                    if (turn) {
                        zar.addMouseListener(oyuncuZarMouse);
                    }   rakip.remove(zar);
                    orta.add(zar);
                    refresh();
                    break;
                case 3:
                    zarlariAt(2);
                    break;
                default:
                    break;
            }
            
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="rakipler arası iletişim">
    void mesajlas(String mesaj) {
        if (myClient != null && myClient.isConnected) {
            if (mesaj.equals("match_me")) {
                myClient.SendMessage(mesaj);
            } else {
                myClient.SendMessage("{" + enemy + "}" + "#" + mesaj);
                //"{"+enemy+"}#"+msg
            }
        }
    }
//</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Zar alma ve verme">    
    MouseAdapter ortaZarMouse = new MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            oyuncuZarClicked(evt);
        }
    };

    MouseAdapter oyuncuZarMouse = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            ortaZarClicked(evt);
        }
    };

    private void ortaZarClicked(java.awt.event.MouseEvent evt) {
        Component zar = evt.getComponent();

        zar.setLocation(zar.getLocation().x, 31);

        zar.removeMouseListener(oyuncuZarMouse);
        zar.removeMouseListener(ortaZarMouse);

        zar.addMouseListener(ortaZarMouse);

        orta.remove(evt.getComponent());
        oyuncu.add(zar);
        mesajlas("ZarAl[" + zar.getAccessibleContext().getAccessibleName().substring(3) + "]");

        refresh();
    }

    private void oyuncuZarClicked(java.awt.event.MouseEvent evt) {
        Component zar = evt.getComponent();
        zar.setLocation(zar.getLocation().x, 30);

        zar.removeMouseListener(ortaZarMouse);
        zar.removeMouseListener(oyuncuZarMouse);

        zar.addMouseListener(oyuncuZarMouse);

        oyuncu.remove(evt.getComponent());
        orta.add(zar);

        mesajlas("ZarVer[" + zar.getAccessibleContext().getAccessibleName().substring(3) + "]");
        refresh();
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="gelen zarları döner">
    public String gelenZarlar() {
        JLabel[] images = new JLabel[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6};
        String res = "";
        for (JLabel img : images) {
            res += img.getAccessibleContext().getAccessibleDescription() + ",";
        }
        return res.substring(0, res.length() - 1);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="zarları, aldığı parametreye göre düzenler">
    public void zarlariDuzenle(String zarlar) {
        String[] dice = new String[]{"", "one", "two", "three", "four", "five", "six"};
        String[] zarDuzeni = zarlar.split("\\,", -1);
        JLabel[] images = new JLabel[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6};
        for (int i = 1; i <= 5; i++) {

            images[i - 1].setText("");

            if (turn) {
                images[i - 1].addMouseListener(oyuncuZarMouse);
            }

            int k = Integer.parseInt(zarDuzeni[i - 1]);
            ImageIcon icon = new ImageIcon("dice/" + dice[k] + ".jpg");
            Image image = icon.getImage();
            Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
            images[i - 1].setIcon(new ImageIcon(newimg));
            images[i - 1].getAccessibleContext().setAccessibleDescription("" + k);

        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="tablo hesaplama">
    void Calculate(int player) {

        for (int j = 0; j < 17; j++) {
            if (gameCard.getValueAt(j, player) != null && "*".equals(gameCard.getValueAt(j, player).toString().substring(0, 1))) {
            } else {
                gameCard.setValueAt(null, j, player);
            }
        }

        JLabel[] images = new JLabel[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6};

        for (JLabel img : images) {

            //UPPER SECTION
            for (int j = 0; j < 6; j++) {
                if (Integer.parseInt(img.getAccessibleContext().getAccessibleDescription()) == (j + 1)) {
                    if (gameCard.getValueAt(j, player) != null && "*".equals(gameCard.getValueAt(j, player).toString().substring(0, 1))) {
                    } else {
                        int value = (gameCard.getValueAt(j, player) == null) ? 0 : Integer.parseInt(gameCard.getValueAt(j, player).toString());
                        gameCard.setValueAt(value + j + 1, j, player);
                    }
                }
            }
        }

        //CHANCE
        int value = 0;
        for (JLabel img : images) {
            value += Integer.parseInt(img.getAccessibleContext().getAccessibleDescription());
        }
        if (gameCard.getValueAt(15, player) != null && "*".equals(gameCard.getValueAt(15, player).toString().substring(0, 1))) {
        } else {
            gameCard.setValueAt(value, 15, player);
        }
        /*   //YATZHEE
        int same = 0;
        for (JLabel img : images) {
        if (same == 0) {
        Integer.parseInt(img.getAccessibleContext().getAccessibleDescription());
        continue;
        }
        if (same == Integer.parseInt(img.getAccessibleContext().getAccessibleDescription())) {
        continue;
        } else {
        same = -1;
        break;
        }
        }
        if (same != -1) {
        jTable1.setValueAt(50, 16, 1);
        }
        
        //büyük düz i guess
        boolean[] res = new boolean[6];
        for (JLabel img : images) {
        res[Integer.parseInt(img.getAccessibleContext().getAccessibleDescription()) - 1] = true;
        }
        if ((res[0] == true && res[1] == true && res[2] == true && res[3] == true && res[4] == true)
        || (res[1] == true && res[2] == true && res[3] == true && res[4] == true && res[5] == true)) {
        jTable1.setValueAt(50, 14, 1);
        }*/
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="oyunu başlat">
    public void start(boolean first) {
        if (first) {
            zarAt.setEnabled(true);
            jLabel9.setText("Your turn!");
            turn = true;
        } else {
            zarAt.setEnabled(false);
            jLabel9.setText("Waiting for enemy's move");
            turn = false;
            JLabel[] images = new JLabel[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6};

            for (JLabel img : images) {

                img.removeMouseListener(oyuncuZarMouse);
                img.removeMouseListener(ortaZarMouse);

            }
        }

        acceptBtn.setEnabled(false);
        jLabel8.setText("Started a Match. Your enemy is " + enemy);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="gui tazeleme">
    void refresh() {
        orta.repaint();
        oyuncu.repaint();
        rakip.repaint();
    }
//</editor-fold>
    
    
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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton acceptBtn;
    private javax.swing.JButton connectServer;
    private javax.swing.JTable gameCard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    private static javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel orta;
    private javax.swing.JPanel oyuncu;
    private javax.swing.JPanel rakip;
    public static javax.swing.JButton zarAt;
    // End of variables declaration//GEN-END:variables

}

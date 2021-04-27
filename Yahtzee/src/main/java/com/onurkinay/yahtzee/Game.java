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
import javax.swing.JOptionPane;

/**
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
    public int oyunTur = 0;
    int secilen = -1;
    boolean sonKarar = false;

    public Game() {
        initComponents();

        String[] dice = new String[]{"", "one", "two", "three", "four", "five", "six"};
        ArrayList<JLabel> zarlar = new ArrayList<>();
        for (Component gelenler : orta.getComponents()) {
            if (gelenler instanceof JLabel) {
                zarlar.add((JLabel) gelenler);
            }
        }
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

        jLabel7.setText("");
        jLabel8.setText("");
        jLabel1.setText("");
        jLabel9.setText("");

        gameCard.setDefaultRenderer(Object.class, new CardRenderer());
        findAMatch.setEnabled(false);
        connectServer.getAccessibleContext().setAccessibleDescription("connect");

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gameCard = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
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
        findAMatch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
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
                {"Upper Sum", null, null},
                {"Bonus", null, null},
                {null, null, null},
                {"Three of a kind", null, null},
                {"Four of a kind", null, null},
                {"Full House", null, null},
                {"Small straight", null, null},
                {"Large straight", null, null},
                {"Chance", null, null},
                {"YAHTZEE", null, null},
                {"YAHTZEE Bonus", null, null},
                {null, null, null},
                {"Lower Sum", null, null},
                {null, null, null},
                {"TOTAL", null, null}
            },
            new String [] {
                "", "You", "Enemy"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        gameCard.setEnabled(false);
        gameCard.setShowGrid(true);
        gameCard.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                gameCardMouseMoved(evt);
            }
        });
        gameCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gameCardMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gameCardMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(gameCard);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 289, 380));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, -1, -1));

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
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        oyuncu.setBackground(new java.awt.Color(204, 0, 183));
        oyuncu.setName("orta"); // NOI18N
        oyuncu.setLayout(null);
        getContentPane().add(oyuncu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 600, 120));

        rakip.setBackground(new java.awt.Color(51, 255, 0));
        rakip.setName("orta"); // NOI18N
        rakip.setLayout(null);
        getContentPane().add(rakip, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 600, 120));

        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, -1, -1));

        connectServer.setText("Connect Server");
        connectServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectServerActionPerformed(evt);
            }
        });
        getContentPane().add(connectServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 510, 280, -1));

        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        findAMatch.setText("Find a Match");
        findAMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findAMatchActionPerformed(evt);
            }
        });
        getContentPane().add(findAMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 540, 280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void gameCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameCardMouseClicked
        // TODO add your handling code here:
        if (turn) {
            int row = gameCard.rowAtPoint(evt.getPoint());

            int col = gameCard.columnAtPoint(evt.getPoint());
            if (gameCard.getValueAt(row, 1) != null && "*".equals(gameCard.getValueAt(row, 1).toString().substring(0, 1))) {
                jLabel1.setText("Seçemezsiniz");
            } else {
                if (col == 1) {
                    if (row == 6 || row == 7 || row == 8 || row == 9 || row == 21 || row == 20 || row == 19 || row == 18) {
                        jLabel1.setText("Hatalı Seçim");
                        secilen = -1;
                    } else {
                        // jLabel1.setText("" + jTable1.getValueAt(row, 0).toString() + " of Player #" + col);
                        jLabel1.setText("" + gameCard.getValueAt(row, 0).toString() + " seçildi");
                        secilen = row;
                        if (sonKarar) {
                            if (secilen != -1) {
                                if (gameCard.getValueAt(secilen, 1) == null) {
                                    gameCard.setValueAt("*0", secilen, 1); // sıfır seçme şansı
                                } else {
                                    if (secilen != 17) {
                                        gameCard.setValueAt("*" + gameCard.getValueAt(secilen, 1).toString(), secilen, 1);
                                    }
                                }
                                for (Component zar : oyuncu.getComponents()) {

                                    zar.setLocation(zar.getLocation().x, 30);
                                    zar.removeMouseListener(ortaZarMouse);
                                    zar.removeMouseListener(oyuncuZarMouse);

                                    // zar.addMouseListener(oyuncuZarMouse);
                                    oyuncu.remove(zar);
                                    orta.add(zar);

                                    refresh();

                                }

                                JLabel[] images = new JLabel[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6};

                                for (JLabel img : images) {

                                    img.removeMouseListener(oyuncuZarMouse);
                                    img.removeMouseListener(ortaZarMouse);

                                }
                                if (oyunTur != -1) {
                                    oyunTur++;
                                }
                                tur = 0;
                                jLabel7.setText("Yeni raund");
                                jLabel1.setText("Herhangi bir seçim yapılmadı");
                                zarAt.setEnabled(false);
                                sonKarar = false;
                                jLabel9.setText("Waiting for enemy's move");
                                turn = false;
                                mesajlas("yourTurn[" + secilen + "]");
                                secilen = -1;

                                tabloTemizle();
                                calculateScore(1);
                                if (oyunTur >= 3) {
                                    finishMatch();
                                    return;
                                }
                            } else {
                                //herhangi bir seçim yapılmadı
                                jLabel1.setText("Herhangi bir seçim yapılmadı");
                            }
                        }
                    }
                } else {
                    jLabel1.setText("Yanlış yere tıkladınız");
                }
            }
            gameCard.repaint();
            gameCard.revalidate();
        }
    }//GEN-LAST:event_gameCardMouseClicked

    private void zarAtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zarAtActionPerformed

        mesajlas("e#zarAt");
        zarlariAt(1);

    }//GEN-LAST:event_zarAtActionPerformed

    private void connectServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectServerActionPerformed
        // TODO add your handling code here: 
        if ("disconnect".equals(connectServer.getAccessibleContext().getAccessibleDescription())) {
            myClient.Close();
            myClient = null;
            this.setTitle("No connection...");

            findAMatch.setEnabled(false);

            connectServer.setText("Connect Server");
            connectServer.getAccessibleContext().setAccessibleDescription("connect");

        }

        if (myClient == null) {
            Object[] servers = {"127.0.0.1", "3.142.40.78"};
            String ip = (String) JOptionPane.showInputDialog(
                    this,
                    "Bağlantı kurulacak sunucu seçiniz...",
                    "Sunucu seçin...",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    servers,
                    "127.0.0.1");

            if ((ip != null) && (ip.length() > 0)) {
                // myClient = new cClient("127.0.0.1", 5000);
                myClient = new cClient(ip, 5000);
                myClient.Start();

                connectServer.setText("Disconnect Server");
                connectServer.getAccessibleContext().setAccessibleDescription("disconnect");
                this.setTitle("Connected Server: " + ip);
                findAMatch.setEnabled(true);
                findAMatch.getAccessibleContext().setAccessibleDescription("arama");
                return;
            }

        } else if (!myClient.isConnected) {
            myClient.Start();
        }

    }//GEN-LAST:event_connectServerActionPerformed

    public int rollOverRowIndex = -1;
    public int rollOverColIndex = -1;
    private void gameCardMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameCardMouseMoved
        int row = gameCard.rowAtPoint(evt.getPoint());
        int col = gameCard.columnAtPoint(evt.getPoint());
        if (turn) {
            if (row != rollOverRowIndex) {
                if (!(row == 6 || row == 7 || row == 8 || row == 9 || row == 21 || row == 20 || row == 19 || row == 18)) {
                    if (col == 1) {

                        rollOverRowIndex = row;
                        rollOverColIndex = col;

                    } else {
                        rollOverColIndex = -1;
                        rollOverRowIndex = -1;
                    }
                } else {
                    rollOverColIndex = -1;
                    rollOverRowIndex = -1;
                }
            }

        } else {
            rollOverColIndex = -1;
            rollOverRowIndex = -1;
        }

        gameCard.repaint();
    }//GEN-LAST:event_gameCardMouseMoved

    private void gameCardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameCardMouseExited
        rollOverRowIndex = -1;
        rollOverColIndex = -1;
        gameCard.repaint();
    }//GEN-LAST:event_gameCardMouseExited

    private void findAMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findAMatchActionPerformed
        if ("arama".equals(findAMatch.getAccessibleContext().getAccessibleDescription())) {
            mesajlas("match_me");
            jLabel8.setText("Connected and waiting a enemy");
            findAMatch.setText("Stop searching match");
            findAMatch.getAccessibleContext().setAccessibleDescription("aramaBirak");
        } else if ("terket".equals(findAMatch.getAccessibleContext().getAccessibleDescription())) {
            //Custom button text
            Object[] options = {"Yes",
                "No"};
            int n = JOptionPane.showOptionDialog(this,
                    "Maçı bırakmak istediğinizden emin misiniz",
                    "Maçı bırakma",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
            if (n == 0) {
                mesajlas("quit_the_match");
                quittedMatch();
                jLabel9.setText("Maçı terkettiniz");

            }
        } else if ("aramaBirak".equals(findAMatch.getAccessibleContext().getAccessibleDescription())) {
            mesajlas("quit_for_search");
            jLabel8.setText("Stopped searching match");
            findAMatch.setText("Find a Match");
            findAMatch.getAccessibleContext().setAccessibleDescription("arama");
        }

    }//GEN-LAST:event_findAMatchActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if ("aramaBirak".equals(findAMatch.getAccessibleContext().getAccessibleDescription())) {//finding match mode
            mesajlas("quit_for_search");
            System.out.println("arama terk edildi");
        } else if ("terket".equals(findAMatch.getAccessibleContext().getAccessibleDescription())) { //maç esnasında
            mesajlas("quit_the_match");
            System.out.println("erken ayrıldın");
        }
    }//GEN-LAST:event_formWindowClosing

    //<editor-fold defaultstate="collapsed" desc="rastgele zar atar">
    public void zarlariAt(int player) {

        if (tur < 3) {
            tur++;
            jLabel7.setText("Tur sayısı: " + tur);
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
                        if (player == 1) {
                            mesajlas("GelenZarlar[" + gelenZarlar() + "]");
                            Calculate(player);
                            if (tur >= 3) {
                                jLabel7.setText("Tur sayısı bitti");
                                zarAt.setEnabled(false);
                                if (turn) {

                                    sonKarar = true;
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
                                }
                            }
                        } else if (player == 2) {
                            if (tur >= 3) {
                                sonKarar = false;
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

    //<editor-fold defaultstate="collapsed" desc="aldığı parametreye göre zarları düzenler">
    void zarIsleri(String s) {
        if ((s != null)) {
            // 1-1 -> zar sırası - 1-zarı al/2-zarı geri at/3-roll
            JLabel[] images = new JLabel[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6};

            int zarSirasi = Integer.parseInt(s.substring(0, 1)) - 1;
            JLabel zar = images[zarSirasi];

            int komut = Integer.parseInt(s.substring(2, 3));

            switch (komut) {
                case 1://rakip
                    zar.setLocation(zar.getLocation().x, 31);
                    zar.removeMouseListener(oyuncuZarMouse);
                    zar.removeMouseListener(ortaZarMouse);
                    orta.remove(zar);
                    rakip.add(zar);
                    refresh();
                    break;
                case 2://orta
                    zar.setLocation(zar.getLocation().x, 30);
                    zar.removeMouseListener(ortaZarMouse);
                    zar.removeMouseListener(oyuncuZarMouse);
                    if (turn) {
                        zar.addMouseListener(oyuncuZarMouse);
                    }
                    rakip.remove(zar);
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
            if (mesaj.equals("match_me") || mesaj.equals("quit_for_search")) {
                myClient.SendMessage(mesaj);
            } else {
                myClient.SendMessage("{" + enemy + "}" + "#" + mesaj);
                System.out.println(enemy + " rakibe mesaj gönderildi - " + mesaj);
                //"{"+enemy+"}#"+msg
            }
        }
    }
//</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Zar alma ve verme">    
    MouseAdapter ortaZarMouse = new MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if(enemy != -2)  oyuncuZarClicked(evt);
        }
    };

    MouseAdapter oyuncuZarMouse = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
              if(enemy != -2) ortaZarClicked(evt);
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

        int k = 0;
        for (Component gelenler : oyuncu.getComponents()) {
            if (gelenler instanceof JLabel) {
                k++;
            }
        }
        if (k == 5) {
            sonKarar = true;
        } else {
            sonKarar = false;
        }

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

        int k = 0;
        for (Component gelenler : oyuncu.getComponents()) {
            if (gelenler instanceof JLabel) {
                k++;
            }
        }
        if (k == 5) {
            sonKarar = true;
        } else {
            sonKarar = false;
        }

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
        Calculate(2);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="gameCard hesaplama">
    void Calculate(int player) {

        for (int j = 0; j < 20; j++) {
            if (j == 7 || j == 8 || j == 17 || j == 19) {
                continue;
            }
            tabloyaVeriGir(player, j, null);
        }

        JLabel[] images = new JLabel[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6};

        //UPPER SECTION
        for (JLabel img : images) {

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

        tabloyaVeriGir(player, 15, value);
        //yahtzee
        int same = 0;
        int zarNo = 0;
        for (JLabel img : images) {
            if (same == 0 && zarNo == 0) {
                zarNo = Integer.parseInt(img.getAccessibleContext().getAccessibleDescription());
                continue;
            }
            if (zarNo == Integer.parseInt(img.getAccessibleContext().getAccessibleDescription())) {
                continue;
            } else {
                same = -1;
                break;
            }
        }

        if (same != -1) {
            if (gameCard.getValueAt(16, player) != null && "*0".equals(gameCard.getValueAt(16, player).toString())) {

            } else {
                if (gameCard.getValueAt(16, player) != null && "*50".equals(gameCard.getValueAt(16, player).toString())) { //yahtzee ek bonus
                    if (gameCard.getValueAt(17, player) != null) {
                        int bonus = Integer.parseInt(gameCard.getValueAt(17, player).toString()) + 100;
                        gameCard.setValueAt(bonus, 17, player);
                    } else {
                        tabloyaVeriGir(player, 17, 100);
                    }
                } else {
                    tabloyaVeriGir(player, 16, 50);
                }
            }
        } else {
            tabloyaVeriGir(player, 16, 0);
        }

        //büyük düz 
        boolean[] res = new boolean[6];
        for (JLabel img : images) {
            res[Integer.parseInt(img.getAccessibleContext().getAccessibleDescription()) - 1] = true;
        }
        if ((res[0] == true && res[1] == true && res[2] == true && res[3] == true && res[4] == true)
                || (res[1] == true && res[2] == true && res[3] == true && res[4] == true && res[5] == true)) {

            tabloyaVeriGir(player, 14, 40);
        }
        //küçük düz
        res = new boolean[6];
        for (JLabel img : images) {
            res[Integer.parseInt(img.getAccessibleContext().getAccessibleDescription()) - 1] = true;
        }
        if ((res[0] == true && res[1] == true && res[2] == true && res[3] == true)
                || (res[1] == true && res[2] == true && res[3] == true && res[4] == true)
                || (res[2] == true && res[3] == true && res[4] == true && res[5] == true)) {

            tabloyaVeriGir(player, 13, 30);
        }

        //3 ve 4 tur
        for (int i = 0; i < 5; i++) {
            int k = Integer.parseInt(images[i].getAccessibleContext().getAccessibleDescription());
            int score = k;
            int ayniZarlar = 1;
            for (int j = 0; j < 5; j++) {
                if (j == i) {
                    continue;
                }
                score += Integer.parseInt(images[j].getAccessibleContext().getAccessibleDescription());
                if (Integer.parseInt(images[j].getAccessibleContext().getAccessibleDescription()) == k) {
                    ayniZarlar++;
                }
            }
            if (ayniZarlar >= 3) {
                tabloyaVeriGir(player, 10, score);
            }
            if (ayniZarlar >= 4) {
                tabloyaVeriGir(player, 11, score);
            }
        }

        //full house
        for (int i = 0; i < 5; i++) {
            int k = Integer.parseInt(images[i].getAccessibleContext().getAccessibleDescription());

            int ayniZarlar = 1;
            for (int j = 0; j < 5; j++) {
                if (j == i) {
                    continue;
                }

                if (Integer.parseInt(images[j].getAccessibleContext().getAccessibleDescription()) == k) {
                    ayniZarlar++;
                }
            }
            if (ayniZarlar == 3) {
                int ikinciZar = -1;
                int ikinciTur = 1;
                for (int p = 0; p < 5; p++) {
                    if (Integer.parseInt(images[p].getAccessibleContext().getAccessibleDescription()) == k) {
                        continue;
                    }
                    if (ikinciZar == -1) {
                        ikinciZar = Integer.parseInt(images[p].getAccessibleContext().getAccessibleDescription());
                    } else if (Integer.parseInt(images[p].getAccessibleContext().getAccessibleDescription()) == ikinciZar) {
                        ikinciTur++;
                    }
                }
                if (ikinciTur == 2) {
                    tabloyaVeriGir(player, 12, "25");
                }

            }

        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="tablo puanı hesaplama">
    public void calculateScore(int player) {
        //UPPER SCORE
        int upperScore = 0;
        for (int i = 0; i < 6; i++) {
            if (gameCard.getValueAt(i, player) != null && "*".equals(gameCard.getValueAt(i, player).toString().substring(0, 1))) {
                String deger = gameCard.getValueAt(i, player).toString().substring(1);
                upperScore += Integer.parseInt(deger);
            }
        }
        tabloyaVeriGir(player, 7, upperScore);
        if (upperScore >= 63) {
            tabloyaVeriGir(player, 8, 35);
        } else {
            tabloyaVeriGir(player, 8, 0);
        }

        // LOWER SCORE
        int lowerScore = 0;
        for (int i = 10; i < 18; i++) {
            if (gameCard.getValueAt(i, player) != null) {
                if ("*".equals(gameCard.getValueAt(i, player).toString().substring(0, 1))) {
                    String deger = gameCard.getValueAt(i, player).toString().substring(1);
                    lowerScore += Integer.parseInt(deger);
                } else if (i == 17) {
                    lowerScore += Integer.parseInt(gameCard.getValueAt(i, player).toString());
                }
            }
        }
        tabloyaVeriGir(player, 19, lowerScore);

        int playerScore = 0;
        playerScore += Integer.parseInt(gameCard.getValueAt(7, player).toString()); // upper score
        playerScore += Integer.parseInt(gameCard.getValueAt(8, player).toString()); // bonus score by 63
        playerScore += Integer.parseInt(gameCard.getValueAt(19, player).toString()); // lower score

        tabloyaVeriGir(player, 21, playerScore);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="maçı bitir">
    public void finishMatch() {

        if (oyunTur != -1) {
            mesajlas("macBitir");
        }
        int playerScore = Integer.parseInt(gameCard.getValueAt(21, 1).toString());
        int rivalScore = Integer.parseInt(gameCard.getValueAt(21, 2).toString());

        String mesaj = (playerScore < rivalScore) ? "rakip kazandı" : "sen kazandın";
        jLabel9.setText("Match is over: " + mesaj);
        JOptionPane.showMessageDialog(this,
                mesaj);

        restartGame();

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="oyunu başlat">
    public void start(boolean first) {
        JLabel[] images = new JLabel[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6};
        if (first) {
            zarAt.setEnabled(true);
            jLabel9.setText("Your turn!");
            turn = true;

        } else {
            zarAt.setEnabled(false);
            jLabel9.setText("Waiting for enemy's move");
            turn = false;

            restartDice();
        }
        findAMatch.setText("Maçı bırak...");
        sonKarar = false;
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

    //<editor-fold defaultstate="collapsed" desc="gameCard'a veri girme">
    public boolean tabloyaVeriGir(int player, int satir, Object veri) {
        if (gameCard.getValueAt(satir, player) != null && "*".equals(gameCard.getValueAt(satir, player).toString().substring(0, 1))) {

            return false;
        } else {
            gameCard.setValueAt(veri, satir, player);
            gameCard.repaint();
            gameCard.revalidate();

            return true;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="seçilmemiş puan satırları silme">
    public void tabloTemizle() {
        for (int i = 1; i <= 2; i++) {

            for (int j = 0; j < 20; j++) {
                if (j == 7 || j == 8 || j == 17 || j == 19) {
                    continue;
                }
                if (gameCard.getValueAt(j, i) != null && "*".equals(gameCard.getValueAt(j, i).toString().substring(0, 1))) {
                } else {
                    gameCard.setValueAt(null, j, i);
                }
            }
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="maç terk edildiğinde">
    public void quittedMatch() {
        jLabel9.setText("Rakip, maçı terketti");
        restartGame();

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="oyunu sıfırlama">
    public void restartGame() {
        enemy = -2;
        restartDice();
        connectServer.setEnabled(true);
        findAMatch.setEnabled(true);
        findAMatch.getAccessibleContext().setAccessibleDescription("arama");
        findAMatch.setText("Find a Match");

        jLabel7.setText("");
        jLabel8.setText("");
        jLabel1.setText("");

        sonKarar = false;
        zarAt.setEnabled(false);

        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < 22; j++) {
                gameCard.setValueAt(null, j, i);
            }
        }
        oyunTur = -1;
    }
//</editor-fold>

    public void restartDice() {
        JLabel[] images = new JLabel[]{jLabel2, jLabel3, jLabel4, jLabel5, jLabel6};

        for (JLabel zar : images) {

            zar.setLocation(zar.getLocation().x, 30);
            zar.removeMouseListener(oyuncuZarMouse);
            zar.removeMouseListener(ortaZarMouse);

            rakip.remove(zar);
            oyuncu.remove(zar);
            orta.add(zar);
            refresh();

        }
      
    }

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
    public javax.swing.JButton connectServer;
    public javax.swing.JButton findAMatch;
    public static javax.swing.JTable gameCard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel orta;
    private javax.swing.JPanel oyuncu;
    private javax.swing.JPanel rakip;
    public static javax.swing.JButton zarAt;
    // End of variables declaration//GEN-END:variables

}

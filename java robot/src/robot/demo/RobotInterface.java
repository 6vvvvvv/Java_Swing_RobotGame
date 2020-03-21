import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RobotInterface extends JFrame {
    // constructor
    public RobotInterface() {

        // 4 area in the frame: left, center, right,up
        JPanel left = new JPanel();
        JPanel center = new JPanel();
        JPanel right = new JPanel();
        JPanel up = new JPanel();

        // create a Grid layout as chessboard - This will go in the middle.
        GridLayout grid = new GridLayout(10, 10, 1, 1);
        center.setLayout(grid);

        JLabel[][] label = new JLabel[10][10];

        for (int i = 0; i < label.length; i++) {
            for (int j = 0; j < label[i].length; j++) {
                label[i][j] = new JLabel();
                label[i][j].setBackground(Color.pink);
                label[i][j].setOpaque(true);

                center.add(label[i][j]);
            }
        }

        // import the two robot icons over the label in the left up corner and right up corner respectively
        ImageIcon net = new ImageIcon("C:/Users/liuwg/OneDrive/Desktop/net22.jpg");
        label[0][0].setIcon(net);

        ImageIcon pol = new ImageIcon("C:/Users/liuwg/OneDrive/Desktop/pol22.jpg");
        label[0][9].setIcon(pol);

        // left and right panels holds 3 buttons each. GridLayout will make
        // them occupy equal space
        left.setLayout(new GridLayout(3, 1));
        // Button 1
        JButton Nettoyeurlibre = new JButton("Nettoyeurlibre");
        left.add(Nettoyeurlibre);
        // Button 2
        JButton NettoyeurSmart = new JButton("NettoyeurSmart");
        left.add(NettoyeurSmart);
        // Button 3
        JButton NettoyeurStandard = new JButton("NettoyeurStandard");
        left.add(NettoyeurStandard);

        // right panel
        right.setLayout(new GridLayout(3, 1));
        // Button 4
        JButton Pollueurlibre = new JButton("Pollueurlibre");
        right.add(Pollueurlibre);
        // Button 5
        JButton PollueurSautuers = new JButton("PollueurSautuers");
        right.add(PollueurSautuers);
        // Button 6
        JButton PollueurToutDroit = new JButton("PollueurToutDroit");
        right.add(PollueurToutDroit);

        // two manual console for Nettoyeur and Pollueur
        // two moniteur for display status of Netoyeur and pollueur
        // console for Nettoyeur
        JPanel manualCtrl = new JPanel(new GridLayout(1, 5));

        JPanel moniteurnet = new JPanel(new GridLayout(2, 2));
        JLabel netlocation = new JLabel("Net Location");
        JLabel t_netlocation = new JLabel();
        t_netlocation.setText("X: 0" + " " + "Y: 0");
        JLabel netmanualstatus = new JLabel("NetManualStatus");
        JLabel t_netmanualstatus = new JLabel("Deactive");
        moniteurnet.add(netlocation);
        moniteurnet.add(t_netlocation);
        moniteurnet.add(netmanualstatus);
        moniteurnet.add(t_netmanualstatus);

        JPanel moniteurpol = new JPanel(new GridLayout(2, 2));
        JLabel pollocation = new JLabel("Pol Location", SwingConstants.RIGHT);
        JLabel t_pollocation = new JLabel();
        t_pollocation.setText("X: 0" + " " + "Y: 0");
        t_pollocation.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel polmanualstatus = new JLabel("PolManualStatus", SwingConstants.RIGHT);
        JLabel t_polmanualstatus = new JLabel("Deactive");
        t_polmanualstatus.setHorizontalAlignment(SwingConstants.RIGHT);
        moniteurpol.add(pollocation);
        moniteurpol.add(t_pollocation);
        moniteurpol.add(polmanualstatus);
        moniteurpol.add(t_polmanualstatus);

        JPanel panelHolder = new JPanel();
        panelHolder.setSize(100, 100);
        panelHolder.setLayout(new BorderLayout(1, 1));
        JButton reset = new JButton("Reset");
        panelHolder.add(reset, BorderLayout.CENTER);

        JPanel netManuelctr = new JPanel();
        netManuelctr.setLayout(new BorderLayout(1, 1));

        JButton Nright = new JButton("Nright");
        netManuelctr.add(Nright, BorderLayout.EAST);

        JButton Nleft = new JButton("Nleft");
        netManuelctr.add(Nleft, BorderLayout.WEST);

        JButton Nettoyer = new JButton("Nettoyer");
        netManuelctr.add(Nettoyer, BorderLayout.CENTER); //

        JButton Nup = new JButton("Nup");
        netManuelctr.add(Nup, BorderLayout.NORTH);

        JButton Ndown = new JButton("Ndown");
        netManuelctr.add(Ndown, BorderLayout.SOUTH);

        // console for Pollueur
        JPanel polManuelctr = new JPanel();
        polManuelctr.setLayout(new BorderLayout(1, 1));

        JButton Pright = new JButton("Pright");
        polManuelctr.add(Pright, BorderLayout.EAST);

        JButton Pleft = new JButton("Pleft");
        polManuelctr.add(Pleft, BorderLayout.WEST);

        JButton Polluer = new JButton("Polluer");
        polManuelctr.add(Polluer, BorderLayout.CENTER);

        JButton Pup = new JButton("Pup");
        polManuelctr.add(Pup, BorderLayout.NORTH);

        JButton Pdown = new JButton("Pdown");
        polManuelctr.add(Pdown, BorderLayout.SOUTH);

        // manual button disable by defaut
        Nright.setEnabled(false);
        Nleft.setEnabled(false);
        Nettoyer.setEnabled(false);
        Ndown.setEnabled(false);
        Nup.setEnabled(false);

        Pright.setEnabled(false);
        Pleft.setEnabled(false);
        Polluer.setEnabled(false);
        Pdown.setEnabled(false);
        Pup.setEnabled(false);

        // enable netlibre button
        class Netlibreactive implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                Object src = e.getSource();
                if (src == Nettoyeurlibre) {
                    Nright.setEnabled(true);
                    Nleft.setEnabled(true);
                    Nettoyer.setEnabled(true);
                    Ndown.setEnabled(true);
                    Nup.setEnabled(true);
                    t_netmanualstatus.setText("Active");
                }
            }
        }

        ActionListener Nlibreactive = new Netlibreactive();
        Nettoyeurlibre.addActionListener(Nlibreactive);

        // enable pollibre button
        class Pollibreactive implements ActionListener {

            public void actionPerformed(ActionEvent e) {

                Object src = e.getSource();
                if (src == Pollueurlibre) {
                    Pright.setEnabled(true);
                    Pleft.setEnabled(true);
                    Polluer.setEnabled(true);
                    Pdown.setEnabled(true);
                    Pup.setEnabled(true);
                    t_polmanualstatus.setText("Active");
                }
            }
        }

        ActionListener Plibreactive = new Pollibreactive();
        Pollueurlibre.addActionListener(Plibreactive);

        // console
        // ArrayIndexOutOfBoundsException
        //********************************icon overlap
        // reset
        // display current coordinate
        class doOneclick implements ActionListener {
            // original coordinate of nettoyeur (0,0) up left corner
            int nX = 0;
            int nY = 0;
            // original coordinate of pollueur (0,9) up right corner
            int pX = 0;
            int pY = 9;

            //for registering the starting point of mode alternatively polluting when using mode smart nettoyer
            int tempX = pX;
            int tempY = pY;

            public void actionPerformed(ActionEvent e) {

                Object src = e.getSource();
                if (src == Ndown) {
                    label[nX][nY].setIcon(null);
                    nX += 1;

                    // border check
                    if (nX > 9) {
                        JOptionPane.showMessageDialog(null, "You Are Out Of The Border!", "ArrayIndexOutOfBoundsException", JOptionPane.ERROR_MESSAGE);
                    }
                    if ((nX==pX)&&(nY==pY))
                    {
                        JOptionPane.showMessageDialog(null, "BOOM! Nettoyeur Win", "Collision", JOptionPane.ERROR_MESSAGE);
                    }
                    label[nX][nY].setIcon(net);
                    t_netlocation.setText("X:" + nX + " " + "Y:" + nY);
                }

                else if (src == Nup) {
                    label[nX][nY].setIcon(null);
                    nX--;

                    // border check
                    if (nX < 0) {
                        JOptionPane.showMessageDialog(null, "You Are Out Of The Border!", "ArrayIndexOutOfBoundsException", JOptionPane.ERROR_MESSAGE);
                    }

                    // collision check
                    if ((nX==pX)&&(nY==pY))
                    {
                        JOptionPane.showMessageDialog(null, "BOOM! Nettoyeur Win", "Collision", JOptionPane.ERROR_MESSAGE);
                    }
                    label[nX][nY].setIcon(net);
                    t_netlocation.setText("X:" + nX + " " + "Y:" + nY);
                }

                else if (src == Nleft) {
                    label[nX][nY].setIcon(null);
                    nY--;

                    // border check
                    if (nY < 0) {
                        JOptionPane.showMessageDialog(null, "You Are Out Of The Border!", "ArrayIndexOutOfBoundsException", JOptionPane.ERROR_MESSAGE);
                    }

                    // collision check
                    if ((nX==pX)&&(nY==pY))
                    {
                        JOptionPane.showMessageDialog(null, "BOOM! Nettoyeur Win", "Collision", JOptionPane.ERROR_MESSAGE);
                    }
                    label[nX][nY].setIcon(net);
                    t_netlocation.setText("X:" + nX + " " + "Y:" + nY);
                }

                else if (src == Nright) {
                    label[nX][nY].setIcon(null);
                    nY++;

                    // border check
                    if (nY > 9) {
                        JOptionPane.showMessageDialog(null, "You Are Out Of The Border!", "ArrayIndexOutOfBoundsException", JOptionPane.ERROR_MESSAGE);
                    }

                    // collision check
                    if ((nX==pX)&&(nY==pY))
                    {
                        JOptionPane.showMessageDialog(null, "BOOM! Nettoyeur Win", "Collision", JOptionPane.ERROR_MESSAGE);
                    }
                    label[nX][nY].setIcon(net);
                    t_netlocation.setText("X:" + nX + " " + "Y:" + nY);
                }

                // nettoyer the case manually
                else if (src == Nettoyer) {
                    label[nX][nY].setBackground(Color.pink);
                }

                else if (src == Pdown) {
                    label[pX][pY].setIcon(null);
                    pX++;

                    // border check
                    if (pX > 9) {
                        JOptionPane.showMessageDialog(null, "You Are Out Of The Border!", "ArrayIndexOutOfBoundsException", JOptionPane.ERROR_MESSAGE);
                    }

                    // collision check
                    if ((nX==pX)&&(nY==pY))
                    {
                        JOptionPane.showMessageDialog(null, "BOOM! Pollueur Win", "Collision", JOptionPane.ERROR_MESSAGE);
                    }
                    label[pX][pY].setIcon(pol);
                    t_pollocation.setText("X:" + pX + " " + "Y:" + pY);
                }

                else if (src == Pup) {
                    label[pX][pY].setIcon(null);
                    pX--;

                    // border check
                    if (pX < 0) {
                        JOptionPane.showMessageDialog(null, "You Are Out Of The Border!", "ArrayIndexOutOfBoundsException", JOptionPane.ERROR_MESSAGE);
                    }

                    // collision check
                    if ((nX==pX)&&(nY==pY))
                    {
                        JOptionPane.showMessageDialog(null, "BOOM! Pollueur Win", "Collision", JOptionPane.ERROR_MESSAGE);
                    }
                    label[pX][pY].setIcon(pol);
                    t_pollocation.setText("X:" + pX + " " + "Y:" + pY);
                }

                else if (src == Pleft) {
                    label[pX][pY].setIcon(null);
                    pY--;

                    // border check
                    if (pY < 0) {
                        JOptionPane.showMessageDialog(null, "You Are Out Of The Border!", "ArrayIndexOutOfBoundsException", JOptionPane.ERROR_MESSAGE);
                    }

                    // collision check
                    if ((nX==pX)&&(nY==pY))
                    {
                        JOptionPane.showMessageDialog(null, "BOOM! Pollueur Win", "Collision", JOptionPane.ERROR_MESSAGE);
                    }
                    label[pX][pY].setIcon(pol);
                    t_pollocation.setText("X:" + pX + " " + "Y:" + pY);
                }

                else if (src == Pright) {
                    label[pX][pY].setIcon(null);
                    pY++;

                    // border check
                    if (pY > 9) {
                        JOptionPane.showMessageDialog(null, "You Are Out Of The Border!", "ArrayIndexOutOfBoundsException", JOptionPane.ERROR_MESSAGE);
                    }

                    // collision check
                    if ((nX==pX)&&(nY==pY))
                    {
                        JOptionPane.showMessageDialog(null, "BOOM! Pollueur Win", "Collision", JOptionPane.ERROR_MESSAGE);
                    }
                    label[pX][pY].setIcon(pol);
                    t_pollocation.setText("X:" + pX + " " + "Y:" + pY);
                }

                // polluer the case manually
                else if (src == Polluer) {
                    label[pX][pY].setBackground(Color.black);
                    label[pX][pY].setOpaque(true);
                }

                // nettoyer the case spaciously
                else if (src == NettoyeurStandard) {
                    label[nX][nY].setIcon(null);
                    label[tempX][tempY].setIcon(null);

                    // move to the starting point of alternatively polluting and begin cleaning job
                    // it must be 6 with respect to 8 for the upperlimit of mode alternatively polluting
                    // in order to avoid collision between two robots
                    while (tempX < 8) {
                        label[tempX][tempY].setBackground(Color.pink);
                        tempX += 1;
                        if(tempX==pX)
                        {
                            JOptionPane.showMessageDialog(null, "BOOM! Pollueur Win", "Collision", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    label[tempX][tempY].setBackground(Color.pink);
                    label[tempX][tempY].setIcon(net);

                    nX=tempX;
                    nY=tempY;
                    t_netlocation.setText("X:" + tempX + " " + "Y:" + tempY);
                }

                // polluer the case spaciously
                else if (src == PollueurToutDroit) {
                    tempX = pX;
                    tempY = pY;

                    label[pX][pY].setIcon(null);
                    while (pX < 9) {
                        label[pX][pY].setBackground(Color.black);
                        pX += 1;
                    }
                    label[pX][pY].setBackground(Color.black);
                    label[pX][pY].setIcon(pol);
                    t_pollocation.setText("X:" + pX + " " + "Y:" + pY);
                }


                // smartnettoyer the case, it has to be using after initiate the mode alternatively polluting
                else if (src == NettoyeurSmart) {
                    label[nX][nY].setIcon(null);
                    label[tempX][tempY].setIcon(null);

                    // move to the starting point of alternatively polluting and begin cleaning job
                    // it must be 6 with respect to 8 for the upperlimit of mode alternatively polluting
                    // in order to avoid collision between two robots
                    while (tempX < 6) {
                        label[tempX][tempY].setBackground(Color.pink);
                        tempX += 2;
                    }
                    label[tempX][tempY].setBackground(Color.pink);
                    label[tempX][tempY].setIcon(net);
                    t_netlocation.setText("X:" + tempX + " " + "Y:" + tempY);
                }

                // polluer the case alternatively
                else if (src == PollueurSautuers) {
                    tempX = pX;
                    tempY = pY;

                    label[pX][pY].setIcon(null);
                    while (pX < 8) {
                        label[pX][pY].setBackground(Color.black);
                        pX += 2;
                    }
                    label[pX][pY].setBackground(Color.black);
                    label[pX][pY].setIcon(pol);
                    t_pollocation.setText("X:" + pX + " " + "Y:" + pY);
                }

                //reset all status
                else if (src == reset) {
                    Nright.setEnabled(false);
                    Nleft.setEnabled(false);
                    Nettoyer.setEnabled(false);
                    Ndown.setEnabled(false);
                    Nup.setEnabled(false);

                    Pright.setEnabled(false);
                    Pleft.setEnabled(false);
                    Polluer.setEnabled(false);
                    Pdown.setEnabled(false);
                    Pup.setEnabled(false);

                    label[nX][nY].setIcon(null);
                    label[pX][pY].setIcon(null);
                    label[tempX][tempY].setIcon(null);

                    nX = 0;
                    nY = 0;
                    pX = 0;
                    pY = 9;

                    t_netlocation.setText("X:" + nX + " " + "Y:" + nY);
                    t_pollocation.setText("X:" + pX + " " + "Y:" + pY);

                    label[nX][nY].setIcon(net);
                    label[pX][pY].setIcon(pol);

                    t_netmanualstatus.setText("Dective");
                    t_polmanualstatus.setText("Dective");

                    for (int i = 0; i < label.length; i++) {
                        for (int j = 0; j < label[i].length; j++) {
                            label[i][j].setBackground(Color.pink);
                        }
                    }
                }
            }
        }

        // instance of class doOneclick
        ActionListener oneclick = new doOneclick();

        // buttons addActionListener

        Ndown.addActionListener(oneclick);
        Nup.addActionListener(oneclick);
        Nright.addActionListener(oneclick);
        Nleft.addActionListener(oneclick);

        Pdown.addActionListener(oneclick);
        Pup.addActionListener(oneclick);
        Pright.addActionListener(oneclick);
        Pleft.addActionListener(oneclick);

        Nettoyer.addActionListener(oneclick);
        Polluer.addActionListener(oneclick);

        reset.addActionListener(oneclick);

        NettoyeurStandard.addActionListener(oneclick);
        PollueurToutDroit.addActionListener(oneclick);

        PollueurSautuers.addActionListener(oneclick);
        NettoyeurSmart.addActionListener(oneclick);

        // manualpanel add two console panels
        //********************two textfield
        manualCtrl.add(moniteurnet);
        manualCtrl.add(netManuelctr);
        manualCtrl.add(panelHolder);
        manualCtrl.add(polManuelctr);
        manualCtrl.add(moniteurpol);
        up.add(manualCtrl);

        // add JPanel to content pane which uses Borderlayout by default
        getContentPane().add(left, BorderLayout.WEST);
        getContentPane().add(center, BorderLayout.CENTER);
        getContentPane().add(right, BorderLayout.EAST);
        getContentPane().add(up, BorderLayout.NORTH);

        // set window parameters
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Robot");

        // setSize ( 200, 200 ); //size set by layout
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        new RobotInterface();
    }

}

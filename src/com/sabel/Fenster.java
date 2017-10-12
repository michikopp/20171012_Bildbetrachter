package com.sabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fenster extends JFrame{

    private JPanel jpSouth, jpWest, jpCenter;
    private JButton jbNextPicture, jbPreviousPicture;
    private JRadioButton[] jradios;
    private ButtonGroup buttonGroup;
    private Icon[] icon;
    private JScrollPane jScrollPane;
    private JLabel jLabel;


    public Fenster() {
        super("Bilder");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.initialComponents();
        this.initEvents();
        this.setSize(400, 400);
        this.setVisible(true);
    }



    private void initialComponents() {
        //Buttons Sout
        jpSouth = new JPanel();
        jbNextPicture = new JButton("Vorheriges Bild");
        jbPreviousPicture = new JButton("Nächstes Bild");
        jpSouth.add(jbNextPicture);
        jpSouth.add(jbPreviousPicture);


        //RadioButtons West
        jpWest = new JPanel();
        jpWest.setLayout(new BoxLayout(jpWest, BoxLayout.Y_AXIS));
        jradios = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            jradios[i] = new JRadioButton("Bild" + (i + 1));
            jpWest.add(jradios[i]);
            buttonGroup.add(jradios[i]);
        }
        jradios[0].setSelected(true);



        //Bilder Center
        jpCenter = new JPanel();
        icon = new ImageIcon[4];
        for (int i = 0; i < 4; i++) {
            icon[i] = new ImageIcon("D:\\Kopp\\_Privat\\Programmieren\\IdeaProjects\\20171012_Bildbetrachter\\src\\com\\sabel\\bilder\\Bild" + (i+1) +".jpg");


        }
        jLabel = new JLabel(icon[0]);
        jScrollPane = new JScrollPane(jLabel);



        this.add(jpSouth, BorderLayout.SOUTH);
        this.add(jpWest, BorderLayout.WEST);
        this.add(jScrollPane, BorderLayout.CENTER);

    }

    private void initEvents() {
        jradios[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jLabel.setIcon(icon[1]);
            }
        });


    }
}

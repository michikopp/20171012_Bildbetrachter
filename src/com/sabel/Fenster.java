package com.sabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Fenster extends JFrame{

    private JPanel jpSouth, jpWest;
    private JButton jbNextPicture, jbPreviousPicture;
    private JRadioButton[] jradios;
    private ButtonGroup buttonGroup;
    private Icon[] icon;
    private JScrollPane jScrollPane;
    private JLabel jLabel;
    private int index;


    public Fenster() {
        super("Bildbetrachter");
        index = 0;
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.initialComponents();
        this.initEvents();
        this.setSize(400, 400);
        this.setVisible(true);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    private void initialComponents() {
        //Buttons Sout
        jpSouth = new JPanel();
        jbNextPicture = new JButton("Nächstes Bild");
        jbPreviousPicture = new JButton("Vorheriges Bild");
        jpSouth.add(jbPreviousPicture);
        jpSouth.add(jbNextPicture);


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

        icon = new ImageIcon[4];
        for (int i = 0; i < icon.length; i++) {
            icon[i] = new ImageIcon("D:\\Kopp\\_Privat\\Programmieren\\IdeaProjects\\20171012_Bildbetrachter\\src\\com\\sabel\\bilder\\Bild" + (i+1) +".jpg");
            //icon[i] = new ImageIcon("C:\\Users\\micha\\IdeaProjects\\20171012_Bildbetrachter\\src\\com\\sabel\\bilder\\Bild" + (i+1) +".jpg");


        }
        jLabel = new JLabel(icon[0]);
        jScrollPane = new JScrollPane(jLabel);


        this.add(jpSouth, BorderLayout.SOUTH);
        this.add(jpWest, BorderLayout.WEST);
        this.add(jScrollPane, BorderLayout.CENTER);

    }

    private void initEvents() {
        for (int i = 0; i < jradios.length; i++) {
            int finalI = i;
            jradios[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    jLabel.setIcon(icon[finalI]);
                    setIndex(finalI);
                }
            });
        }

        jbNextPicture.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println(getIndex());
                int temp = getIndex();
                if (temp < 3){
                    temp += 1;
                    jLabel.setIcon(icon[temp]);
                    setIndex(temp);
                    jradios[temp].setSelected(true);
                } else {
                    jLabel.setIcon(icon[0]);
                    setIndex(0);
                    jradios[0].setSelected(true);
                }
            }
        });


        jbPreviousPicture.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int temp = getIndex();
                if (temp == 0){
                    jLabel.setIcon(icon[3]);
                    setIndex(3);
                    jradios[3].setSelected(true);
                } else {
                    temp -=1;
                    jLabel.setIcon(icon[temp]);
                    setIndex(temp);
                    jradios[temp].setSelected(true);
                }
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(Fenster.this,
                        "Wollen Sie das Programm wirklich beenden?",
                        "Programm beenden",JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION){
                    System.exit(NORMAL);
                }

            }
        });
    }
}

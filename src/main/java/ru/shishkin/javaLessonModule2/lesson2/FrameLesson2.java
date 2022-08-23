package ru.shishkin.javaLessonModule2.lesson2;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FrameLesson2 extends JFrame {
    public FrameLesson2() {
        setLocation(0, 0);

        setAlwaysOnTop(true);

        setLayout(new FlowLayout());

        setUndecorated(true);

        JButton button = new JButton();
        button.setName("button");
        button.setText("����");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProcessBuilder process = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "http:\\club.1c.ru");
                try {
                    process.start();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        add(button);

        JButton button1 = new JButton();
        button1.setName("button1");
        button1.setText("�����������");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProcessBuilder process = new ProcessBuilder("calc");
                try {
                    process.start();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        add(button1);

        JButton button2 = new JButton();
        button2.setName("button1");
        button2.setText("�������");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProcessBuilder process = new ProcessBuilder("notepad");
                try {
                    process.start();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        add(button2);

        JButton button3 = new JButton();
        button3.setName("button1");
        button3.setText("�������");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(button3);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }
}

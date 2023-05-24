package ru.shishkin.pacman;

import javax.swing.JFrame;

public class Application extends JFrame {
    public Application() {
        add(new Pacman());
    }

    public static void main(String[] args) {
        Application pac = new Application();
        pac.setVisible(true);
        pac.setTitle("Pacman");
        pac.setSize(380, 420);
        pac.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pac.setLocationRelativeTo(null);

    }
}

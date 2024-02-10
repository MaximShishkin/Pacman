package ru.shishkin.maxim.pacman;

import javax.swing.JFrame;

public class App extends JFrame {
    public App() {
        add(new Pacman());
    }

    public static void main(String[] args) {
        App pac = new App();
        pac.setVisible(true);
        pac.setTitle("Pacman");
        pac.setSize(380, 420);
        pac.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pac.setLocationRelativeTo(null);
    }
}

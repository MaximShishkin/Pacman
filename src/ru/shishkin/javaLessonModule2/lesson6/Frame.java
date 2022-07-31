package ru.shishkin.javaLessonModule2.lesson6;

import javax.swing.JFrame;

public class Frame extends JFrame{
	// конструктор класса
	Frame() {
		// настройки окна
		setBounds(10, 10, 1315, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(new Panel());
		setVisible(true);
	}
}

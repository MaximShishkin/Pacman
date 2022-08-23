package ru.shishkin.javaLessonModule2.lesson6;

import javax.swing.JFrame;

public class FramePaint extends JFrame{
	// конструктор класса
	FramePaint() {
		// настройки окна
		setBounds(10, 10, 1315, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(new PanelPaint());
		setVisible(true);
	}
}

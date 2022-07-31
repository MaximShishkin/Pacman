package Lesson2;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyFrame extends JFrame {
	// конструктор класса
	public MyFrame () {
		
	    // название окна 
		// setTitle("ќкошечко");
		
		// координаты дл€ отрисовки
		setLocation(0,0);
		
		// разместить поверх других окон
		setAlwaysOnTop(true);
		
		// устанавливаем кнопки слева направо автоматически
		setLayout(new FlowLayout());
		
		// убрать рамку окна
		setUndecorated(true);
		
		// добавим кнопку
		JButton button = new JButton();
		button.setName("button");
		button.setText("’ром");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// открываем гугл хром
				ProcessBuilder process = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","http:\\club.1c.ru");
				try {
					process.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}	
		});
		add(button);
		
		// добавим кнопку
		JButton button1 = new JButton();
		button1.setName("button1");
		button1.setText(" алькул€тор");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// открываем калькул€тор
				ProcessBuilder process = new ProcessBuilder("calc");
				try {
					process.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});		
		add(button1);
		
		// добавим кнопку
		JButton button2 = new JButton();
		button2.setName("button1");
		button2.setText("Ѕлокнот");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// открываем блокнот
				ProcessBuilder process = new ProcessBuilder("notepad");
				try {
					process.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}	
			});		
		add(button2);
		
		// добавим кнопку
		JButton button3 = new JButton();
		button3.setName("button1");
		button3.setText("«акрыть");
		button3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				// закрываем программу
				System.exit(0);
			}	
		});		
		add(button3);
		
		// устанавливаем размеры окна автоматически
		pack();
		
		// завершение работы приложени€ при закрытии окна
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// делать видимым окно
		setVisible(true);
	}
}

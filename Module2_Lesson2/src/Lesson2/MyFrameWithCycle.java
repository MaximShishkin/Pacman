package Lesson2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrameWithCycle extends JFrame {
	// конструктор класса
		public MyFrameWithCycle () {
			
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
			
			// массив из кнопок
			JButton [] button = new JButton[4];
			
			// цикл с кнопками
			for(int i = 0; i < 4; i++) {
				button [i] = new JButton();
				button [i].setName("button" + i);
				// обработчик событий
				button [i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// определить какую кнопку нажали
						JButton b = (JButton) e.getSource();
						// определить им€ кнопки
						String namebutton = b.getName();
						
						// в зависимости от имени будет что-то делать
						if(namebutton.equals("button0")) {
							// открываем гугл хром
							ProcessBuilder process = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","http:\\club.1c.ru");
							try {
								process.start();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}	
						}
						else if (namebutton.equals("button1") ) {
							// открываем калькул€тор
							ProcessBuilder process = new ProcessBuilder("calc");
							try {
								process.start();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else if (namebutton.equals("button2") ) {
							// открываем блокнот
							ProcessBuilder process = new ProcessBuilder("notepad");
							try {
								process.start();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else if (namebutton.equals("button3") ) {
							// закрываем программу
							System.exit(0);
						}
					}	
				});
				// добавл€ем в окно
				add(button [i]);
			}
			
			// добавми текст кнопок
			button [0].setText("’ром");
			button [1].setText(" алькул€тор");
			button [2].setText("Ѕлокнот");
			button [3].setText("«акрыть");
			
			// устанавливаем размеры окна автоматически
			pack();
			
			// завершение работы приложени€ при закрытии окна
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			// делать видимым окно
			setVisible(true);
		}
}

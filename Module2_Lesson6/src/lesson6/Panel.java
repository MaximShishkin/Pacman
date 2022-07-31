package lesson6;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class Panel extends JPanel {
	// массив из цветов
	private Color [] masColor;
	// координаты мыши
	private int mX = 0, mY = 0;
	// флаг для начала отрисовки
	private Boolean flag = false;
	// выбранный цвет
	private int countColor = 0;
	
	// конструктор класса
	Panel() {
		addMouseListener(new MyMouse1());
		addMouseMotionListener(new MyMouse2());
		
		// добавим элементы в массив
		masColor = new Color[13];
		masColor[0] = Color.BLACK;
		masColor[1] = Color.RED;
		masColor[2] = Color.GREEN;
		masColor[3] = Color.BLUE;
		masColor[4] = Color.YELLOW;
		masColor[5] = Color.ORANGE;
		masColor[6] = new Color(238,238,238);
		masColor[7] = Color.MAGENTA;
		masColor[8] = Color.CYAN;
		masColor[9] = Color.GRAY;
		masColor[10] = Color.LIGHT_GRAY;
		masColor[11] = Color.PINK;
		masColor[12] = Color.DARK_GRAY;
	}
	
	// метод для отрисовки графики
	public void paintComponent(Graphics g) {
		for (int i = 0; i < 13; i++) {
			g.setColor(masColor[i]);
			g.fillRect(100 * i, 0, 100, 100);
		}	
		
		g.setColor(Color.BLACK);
		g.drawLine(0, 100, 1315, 100);
		
		if (flag == true) {
			g.setColor(masColor[countColor]);
			if (countColor == 6) {
				g.fillRect(mX, mY, 20, 20);
			} else {
				g.fillRect(mX, mY, 3, 3);
			}
		}
	}
	
	// класс для работы с мышкой
	private class MyMouse1 implements MouseListener {
		public void mousePressed(MouseEvent e) {
			int cX = e.getX();
			int cY = e.getY();
			
			int count = e.getClickCount();
			
			int countButton = e.getButton();
			
			if (cX > 0 && cX < 1315 && cY > 0 && cY < 100) {
				if(count == 1) {
					if(countButton == 1) {
						countColor = cX / 100;
					}
				}
			}
		}

		public void mouseReleased(MouseEvent e) {
			flag = false;
		}

		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
	}
	
	// класс для работы с мышкой
	private class MyMouse2 implements MouseMotionListener {
		public void mouseDragged(MouseEvent e) {
			int cX = e.getX();
			int cY = e.getY();
			
			if (cY > 100) {
				mX = cX;
				mY = cY;
				
				flag = true;
				
				repaint();
			}
		}
		
		// метод для работы с мышкой при её движении
		public void mouseMoved(MouseEvent e) {
			int cX = e.getX();
			int cY = e.getY();
			
			if(cX > 0 && cX < 1315 && cY > 0 && cY < 100) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			} else {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}
}

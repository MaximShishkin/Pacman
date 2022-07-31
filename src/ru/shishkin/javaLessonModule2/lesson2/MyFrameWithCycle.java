package ru.shishkin.javaLessonModule2.lesson2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrameWithCycle extends JFrame {
	// ����������� ������
		public MyFrameWithCycle () {
			
		    // �������� ���� 
			// setTitle("��������");
			
			// ���������� ��� ���������
			setLocation(0,0);
			
			// ���������� ������ ������ ����
			setAlwaysOnTop(true);
			
			// ������������� ������ ����� ������� �������������
			setLayout(new FlowLayout());
			
			// ������ ����� ����
			setUndecorated(true);
			
			// ������ �� ������
			JButton [] button = new JButton[4];
			
			// ���� � ��������
			for(int i = 0; i < 4; i++) {
				button [i] = new JButton();
				button [i].setName("button" + i);
				// ���������� �������
				button [i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// ���������� ����� ������ ������
						JButton b = (JButton) e.getSource();
						// ���������� ��� ������
						String namebutton = b.getName();
						
						// � ����������� �� ����� ����� ���-�� ������
						if(namebutton.equals("button0")) {
							// ��������� ���� ����
							ProcessBuilder process = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","http:\\club.1c.ru");
							try {
								process.start();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}	
						}
						else if (namebutton.equals("button1") ) {
							// ��������� �����������
							ProcessBuilder process = new ProcessBuilder("calc");
							try {
								process.start();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else if (namebutton.equals("button2") ) {
							// ��������� �������
							ProcessBuilder process = new ProcessBuilder("notepad");
							try {
								process.start();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else if (namebutton.equals("button3") ) {
							// ��������� ���������
							System.exit(0);
						}
					}	
				});
				// ��������� � ����
				add(button [i]);
			}
			
			// ������� ����� ������
			button [0].setText("����");
			button [1].setText("�����������");
			button [2].setText("�������");
			button [3].setText("�������");
			
			// ������������� ������� ���� �������������
			pack();
			
			// ���������� ������ ���������� ��� �������� ����
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			// ������ ������� ����
			setVisible(true);
		}
}

package Lesson8;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame extends JFrame {
	// конструктор класса
	Frame() {
		// произвольое размещение элементов в окне
		setLayout(null);
		
		// создаём шрифт
		Font font = new Font("Sans", 1, 15);
		
		// путь
		JLabel label = new JLabel("Путь к файлу:");
		label.setBounds(80, 10, 120, 30);
		label.setFont(font);
		add(label);
		
		// поле для пути
		JTextField textField = new JTextField();
		textField.setBounds(190, 10, 590, 30);
		textField.setFont(font);
		add(textField);
		textField.setText("D:\\Files\\MakShish\\Desktop\\");
		
		// поле для содержимого файлов
		JTextArea textArea = new JTextArea();
		textArea.setFont(font);
		JScrollPane scrollPane = new JScrollPane(textArea,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(190, 50, 590, 500);
		add(scrollPane);
		
		// создать файл
		JButton button0 = new JButton("Создать файл");
		button0.setBounds(10, 50, 170, 30);
		button0.setFont(font);
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pathFile = textField.getText().trim();
				
				if(pathFile.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Не указан путь!", "Ошибка", 0);
				} else {
					File newFile = new File(pathFile);
					
					try {
						newFile.createNewFile();
						JOptionPane.showMessageDialog(null, "Файл создан!", "Информация", 1);
					} catch (IOException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Файл не создан!", "Ошибка", 0);
					}
				}
			}
		});
		add(button0);
		
		// удалить файл
		JButton button1 = new JButton("Удалить файл");
		button1.setBounds(10, 90, 170, 30);
		button1.setFont(font);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pathFile = textField.getText().trim();
				
				if(pathFile.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Не указан путь!", "Ошибка", 0);
				} else {
					File deleteFile = new File(pathFile);
					
					if(deleteFile.exists()) {
						deleteFile.delete();
						JOptionPane.showMessageDialog(null, "Файл удалён!", "Информация", 1);
					} else {
						JOptionPane.showMessageDialog(null, "Файл не удалён!", "Ошибка", 0);
					}
				}
			}
		});
		add(button1);
		
		// прочитать файл
		JButton button2 = new JButton("Прочитать файл");
		button2.setBounds(10, 130, 170, 30);
		button2.setFont(font);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pathFile = textField.getText().trim();
				
				if(pathFile.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Не указан путь!", "Ошибка", 0);
				} else {
					try {
						InputStream inputStream = new FileInputStream(pathFile);
						
						BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream));
						
						String stringBuf = "";
						
						while(bufReader.ready()) {
							stringBuf += (bufReader.readLine() + "\n");
						}
						
						textArea.setText(stringBuf);
						
						bufReader.close();
						
						inputStream.close();
						
						JOptionPane.showMessageDialog(null, "Файл успешно прочтён!", "Информация", 1);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Файл не удалось прочитать!", "Ошибка", 0);
						e1.printStackTrace();
					}	
				}
			}
		});
		add(button2);
		
		// сохранить в файл
		JButton button3 = new JButton("Сохранить в файл");
		button3.setBounds(10, 170, 170, 30);
		button3.setFont(font);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pathFile = textField.getText().trim();
				
				if(pathFile.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Не указан путь!", "Ошибка", 0);
				} else {
					try {
						OutputStream outputStream = new FileOutputStream(pathFile);
						
						BufferedWriter bufWriter = new BufferedWriter (new OutputStreamWriter(outputStream));
						
						bufWriter.write(textArea.getText());
						
						bufWriter.close();
						
						outputStream.close();
						
						JOptionPane.showMessageDialog(null, "Запись в файл завершена успешно!", "Информация", 1);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Файл не удалось записать в файл!", "Ошибка", 0);
						e1.printStackTrace();
					}	
				}
			}
		});
		add(button3);
		
		// настройки окна
		setBounds(10, 10, 805, 595);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Мой проводник 2.0");
		setVisible(true);
	}
}

package ru.shishkin.javaLessonModule2.lesson3;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class FrameCalculator extends JFrame {

	private JButton [] button = new JButton [20];
	
	private int x = 10;
	private	int y = 60;	
	
	private JTextArea textArea;
	
	private double p1 = 0, p2 = 0;
	
	private int operation;
	
	FrameCalculator() {
		
		Font buttonFont = new Font("arial", 2, 30);
		
		textArea = new JTextArea();
		
		textArea.setBounds(10, 10, 390, 40);
		
		textArea.setFont(buttonFont);
		
		add(textArea);
		
		for(int i = 0; i < 20; i++) {
			button [i] = new JButton();
			
			if(i > 0 && i % 4 == 0) {
				x = 10;
				y = y + 100;
			}
			
			if(i < 10) {
				button [i].setText("" + i);
			}
			
			button [i].setSize(90,90);
			
			button [i].setFont(buttonFont);
			
			button [i].setLocation(x, y);
			
			button [i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonClick((JButton) e.getSource());
				}
			});
			
			x = x + 100;
			
			add(button [i]);
		}
		
		button [10].setText(".");
		button [11].setText("C");
		button [12].setText("+");
		button [13].setText("-");
		button [14].setText("*");
		button [15].setText("/");
		button [16].setText("^2");
		button [17].setText("^");
		button [18].setText("sqrt");
		button [19].setText("=");
		
		setLayout(null);
		
		Image icon = null;
		
		try {
			icon = ImageIO.read(FrameCalculator.class.getResource("icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setIconImage(icon);
		
		setBounds(10, 10, 425, 595);
		
		setTitle("Калькулятор");
		
		setResizable(false);
		
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void buttonClick(JButton buttonclick) {
		String buttonName = buttonclick.getText();
		double resh = 0;
		
		if(buttonName.equals("+")) {
			operation = 1;
			p1 = Double.parseDouble(textArea.getText().replace(",", "."));
			textArea.setText("");
			button[12].setBackground(Color.GREEN);
		}
		else if(buttonName.equals("-")) {
			operation = 2;
			p1 = Double.parseDouble(textArea.getText().replace(",", "."));
			textArea.setText("");
			button[13].setBackground(Color.GREEN);
		}
		else if(buttonName.equals("*")) {
			operation = 3;
			p1 = Double.parseDouble(textArea.getText().replace(",", "."));
			textArea.setText("");
			button[14].setBackground(Color.GREEN);
		}
		else if(buttonName.equals("/")) {
			operation = 4;
			p1 = Double.parseDouble(textArea.getText().replace(",", "."));
			textArea.setText("");
			button[15].setBackground(Color.GREEN);
		}
		else if(buttonName.equals("^2")) {
			operation = 5;
			p1 = Double.parseDouble(textArea.getText().replace(",", "."));
			textArea.setText("");
			button[16].setBackground(Color.GREEN);
		}
		else if(buttonName.equals("^")) {
			operation = 6;
			p1 = Double.parseDouble(textArea.getText().replace(",", "."));
			textArea.setText("");
			button[17].setBackground(Color.GREEN);
		}
		else if(buttonName.equals("sqrt")) {
			operation = 7;
			p1 = Double.parseDouble(textArea.getText().replace(",", "."));
			textArea.setText("");
			button[18].setBackground(Color.GREEN);
		}
		else if(buttonName.equals("C")) {
			textArea.setText("");
		}
		else if (buttonName.equals("=")) {
			if(operation == 1) {
				p2 = Double.parseDouble(textArea.getText().replace(",", "."));
				resh = p1 + p2;
				textArea.setText(String.format("%.8f", resh).replace(",", "."));
				button[12].setBackground(null);
			}
			if(operation == 2) {
				p2 = Double.parseDouble(textArea.getText().replace(",", "."));
				resh = p1 - p2;
				textArea.setText(String.format("%.8f", resh).replace(",", "."));
				button[13].setBackground(null);
			}	
			if (operation == 3) {
				p2 = Double.parseDouble(textArea.getText().replace(",", "."));
				resh = p1 * p2;
				textArea.setText(String.format("%.8f", resh).replace(",", "."));
				button[14].setBackground(null);
			}
			if (operation == 4) {
				p2 = Double.parseDouble(textArea.getText().replace(",", "."));
				resh = p1 / p2;
				textArea.setText(String.format("%.8f", resh).replace(",", "."));
				button[15].setBackground(null);
			}
			if(operation == 5) {
				resh = Math.pow(p1, 2);
				textArea.setText(String.format("%.8f", resh).replace(",", "."));
				button[16].setBackground(null);
			}	
			if(operation == 6) {
				p2 = Double.parseDouble(textArea.getText().replace(",", "."));
				resh = Math.pow(p1, p2);
				textArea.setText(String.format("%.8f", resh).replace(",", "."));
				button[17].setBackground(null);
			}	
			if(operation == 7) {
				resh = Math.sqrt(p1);
				textArea.setText(String.format("%.8f", resh).replace(",", "."));
				button[18].setBackground(null);
			}	
		}
		else {
			textArea.setText("" + textArea.getText() + buttonName);
		}
	}
}

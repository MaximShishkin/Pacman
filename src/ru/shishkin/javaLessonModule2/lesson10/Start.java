package ru.shishkin.javaLessonModule2.lesson10;

public class Start {

	public static void main(String[] args) {
		new MyNewThread("2");
		new MyNewThread("3");
		new MyNewThread("4");
		new MyNewThread("5");
		
		for(int i = 0; i<100; i++) {
			System.out.println("Работа 1 потока = " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

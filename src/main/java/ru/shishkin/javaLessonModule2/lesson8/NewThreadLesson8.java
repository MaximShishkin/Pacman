package ru.shishkin.javaLessonModule2.lesson8;

public class NewThreadLesson8 extends Thread {
	String name;
	
	NewThreadLesson8(String name) {
		this.name = name;
		start();
	}
    // запускает действие паралельно 
	public void run() {
		for(int i = 0; i<100; i++) {
			System.out.println("Работа потока " + name + " = " + i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

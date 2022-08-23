package ru.shishkin.javaLessonModule2.lesson8;

public class ApplicationLesson8 {

	public static void main(String[] args) {
		new NewThreadLesson8("2");
		new NewThreadLesson8("3");
		new NewThreadLesson8("4");
		new NewThreadLesson8("5");
		
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

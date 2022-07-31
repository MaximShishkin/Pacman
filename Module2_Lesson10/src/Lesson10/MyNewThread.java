package Lesson10;

public class MyNewThread extends Thread {
	String name;
	
	MyNewThread(String name) {
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

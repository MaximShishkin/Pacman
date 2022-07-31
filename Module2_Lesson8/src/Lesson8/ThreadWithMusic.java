package Lesson8;

import java.io.FileInputStream;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ThreadWithMusic extends Thread{
	ThreadWithMusic() {
		start();
	}
	
	public void run() {
		while(true) {
			try {
				FileInputStream music = new FileInputStream("./src/Lesson8/1.mp3");
				Player player = new Player(music);
				player.play();
				player.close();
				music.close();
			} catch (JavaLayerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

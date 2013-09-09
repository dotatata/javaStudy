package test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(), 1000, 500);
	}
}

class MyTask extends TimerTask {
	private static int i = 0;

	public void run() {
		i += 1;
		System.out.println(i);
	}
}
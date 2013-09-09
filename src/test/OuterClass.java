package test;

import java.util.Timer;
import java.util.TimerTask;

public class OuterClass {
	private int i = 0;
	Timer timer = new Timer();
	TimerTask tt = new TimerTask() {
		@Override
		public void run() {
			i++;
			System.out.println(i);
			if(i == 10){
				timer.cancel();
			}
		}
	};
	
	public void start(){
//		System.out.println("内部类实现计时器:");
//		timer.schedule(new Inner(), 1000, 500);
		System.out.println("匿名内部类实现计时器:");
		timer.schedule(tt, 1000, 500);
	}
	public void print(){
		System.out.println(i);
	}
	
	class Inner extends TimerTask{
		public void run(){
			i++;
			System.out.println(i);
			if(i == 10){
				timer.cancel();
			}
		}
	}
	public static void main(String[] args){
		OuterClass outer = new OuterClass();
		Inner inner = outer.new Inner();
		inner.run();
		outer.start();
	}
}

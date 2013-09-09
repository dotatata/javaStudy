package test.thread_operate;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ExamThread {
	private int i = -1;
	Timer timer = new Timer();
	
	public static void main(String[] args) throws Exception {
		final ExamThread et = new ExamThread();
		ShowNum sn = et.new ShowNum();
		sn.start();
		et.doExam();
	}
	
	private void doExam(){
		Scanner sc = new Scanner(System.in);
		String str = "";
		while(true){
			System.out.println("输入一个数字:(输入exit结束)");
			str = sc.next();
			if(!"exit".equalsIgnoreCase(str)){
				i = Integer.parseInt(str);
			}else{
				timer.cancel();
				break;
			}
		}
	}
	
	class ShowNum extends Thread{
		int flag = 0;
		public void run(){
			timer.schedule(new TimerTask(){
				public void run(){
					flag += 1;
					System.out.println("i current value is " + i + "; flag=" + flag);
				}
			}, 3000, 3000);
		}
	}
}

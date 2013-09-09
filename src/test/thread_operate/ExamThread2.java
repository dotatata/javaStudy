package test.thread_operate;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


// �˴����Ǵ���� ��ʱ����run���� ÿ��ִ�ж����½�һ���߳� ��������һ���̶߳�ʱ��ѯ���������
public class ExamThread2 {
	private int i = -1;
	
	public static void main(String[] args) throws Exception {
		ExamThread2 et = new ExamThread2();
		et.doExam();
	}
	
	private void doExam(){
		Scanner sc = new Scanner(System.in);
		String str = "";
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			public void run(){
				new ShowNum().start();
			}
		}, 3000, 3000);
		
		while(true){
			System.out.println("����һ������:(����exit����)");
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
			System.out.println("i current value is " + i + "; flag=" + flag);
			flag += 1;
		}
	}
}

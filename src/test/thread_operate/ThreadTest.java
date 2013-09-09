package test.thread_operate;

public class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
		Person person = new Person();
		person.start();
		
		Thread thread = new Thread(new PersonR());
		thread.start();
		
		System.out.println("sleep 3s");
		Thread.sleep(3000);
		
		new Thread(){
			public void run(){
				System.out.println("threadAnonymous speaking");
			}
		}.start();
		
		new Thread(new Runnable(){
			public void run(){
				System.out.println("inner class speaking");
			}
		}).start();
		System.out.println("sleep 3s");
		Thread.sleep(3000);
		
		System.out.println("thread synchronized test begin:");
		System.out.println(ThreadTest.class);
		new Person().start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(new PersonR()).start();
	}
}

class Person extends Thread{
	@Override
	public void run(){
		//���������Person�������PersonR�ڲ�run����Ҫ��ͬһ������Ϊ������ 
		//���ﲻ����this ��Ϊ��Thread2�����this�����Thread1��this����ͬһ������ 
		//��ThreadTest.class����ֽ������ ��ǰ������������������ʱ ָ��Ķ���ͬһ������ 
		synchronized (ThreadTest.class) {
			try {
				//�ͷ��������ַ�ʽ ��һ�ַ�ʽ�ǳ�����Ȼ�뿪�������ķ�Χ��Ҳ�����뿪��synchronized�ؼ��ֹ�Ͻ�Ĵ��뷶Χ 
				//��һ�ַ�ʽ������synchronized�ؼ��ֹ�Ͻ�Ĵ����ڲ����ü����������wait���� 
				ThreadTest.class.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Person speaking");
		}
	}
}

class PersonR implements Runnable{
	@Override
	public void run() {
		synchronized (ThreadTest.class) {
			ThreadTest.class.notify();
			System.out.println("PersonR speaking");
		}
	}
}
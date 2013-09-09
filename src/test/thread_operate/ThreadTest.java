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
		//由于这里的Person和下面的PersonR内部run方法要用同一对象作为监视器 
		//这里不能用this 因为在Thread2里面的this和这个Thread1的this不是同一个对象 
		//用ThreadTest.class这个字节码对象 当前虚拟机里引用这个变量时 指向的都是同一个对象 
		synchronized (ThreadTest.class) {
			try {
				//释放锁有两种方式 第一种方式是程序自然离开监视器的范围，也就是离开了synchronized关键字管辖的代码范围 
				//另一种方式就是在synchronized关键字管辖的代码内部调用监视器对象的wait方法 
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
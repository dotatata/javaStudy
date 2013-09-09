package test.interfacetest;

public class Test {
	public static void main(String[] args) {
		int j = 0;
		char c = 'a';

		Runner2 runner2 = new InterTest();
		// Runner2继承了Runner所以run方法有2个多态方法
		runner2.run(j);
		runner2.run(c);

		Runner runner = new InterTest();
		// runner的声明为Runner类型 所以只有Runner的一个run方法
		runner.run(j);
	}
}

interface Runner {
	public void run(int j);
}

interface Runner2 extends Runner {
	public void run(char c);
}

class InterTest implements Runner, Runner2 {
	public void run(int i) {

	}

	public void run(char c) {

	}
}
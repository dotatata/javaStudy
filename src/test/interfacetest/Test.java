package test.interfacetest;

public class Test {
	public static void main(String[] args) {
		int j = 0;
		char c = 'a';

		Runner2 runner2 = new InterTest();
		// Runner2�̳���Runner����run������2����̬����
		runner2.run(j);
		runner2.run(c);

		Runner runner = new InterTest();
		// runner������ΪRunner���� ����ֻ��Runner��һ��run����
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
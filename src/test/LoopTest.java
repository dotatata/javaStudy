package test;

import java.util.Scanner;

public class LoopTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String msg;
		int count = 0;
		int answer = 0;
		int x = 0;
		int y = 0;
		do {
			System.out.println("����y��ʼ����;����q�˳�:");
			msg = sc.next();
			if ("y".equalsIgnoreCase(msg)) {
				for (int i = 1; i <= 5; i++) {
					x = (int) (Math.random() * 100);
					y = (int) (Math.random() * 100);
					answer = x + y;
					System.out.println(i + ". " + x + "+" + y + "=");
					if (answer == sc.nextInt()) {
						System.out.println("Correct!");
						count++;
					} else {
						System.out.println("Incorrect!");
					}
				}
				System.out.println("��ķ�����:" + count * 20);
			} else if ("q".equalsIgnoreCase(msg)) {
				System.out.println("�����˳�.");
				break;
			} else {
				System.out.println("ֻ������y��q;");
				continue;
			}
		} while (true);
	}
}

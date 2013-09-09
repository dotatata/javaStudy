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
			System.out.println("输入y开始考试;输入q退出:");
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
				System.out.println("你的分数是:" + count * 20);
			} else if ("q".equalsIgnoreCase(msg)) {
				System.out.println("考试退出.");
				break;
			} else {
				System.out.println("只能输入y和q;");
				continue;
			}
		} while (true);
	}
}

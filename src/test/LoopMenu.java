package test;

import java.util.Scanner;

public class LoopMenu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int order;
		boolean command = true;
		do {
			System.out.println("������˵���:");
			System.out.println("1.��ʾȫ����¼");
			System.out.println("2.��ѯ��½��¼");
			System.out.println("0.�˳�");

			order = sc.nextInt();
			switch (order) {
			case 1:
				System.out.println("kkkkkkkkkk");
				break;
			case 2:
				System.out.println(new java.util.Date());
				break;
			case 0:
				command = false;
				System.out.println("�˳�");
				break;
			}
		} while (command);
	}
}

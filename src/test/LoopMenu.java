package test;

import java.util.Scanner;

public class LoopMenu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int order;
		boolean command = true;
		do {
			System.out.println("请输入菜单项:");
			System.out.println("1.显示全部记录");
			System.out.println("2.查询登陆记录");
			System.out.println("0.退出");

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
				System.out.println("退出");
				break;
			}
		} while (command);
	}
}

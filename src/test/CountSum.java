package test;

import java.util.Scanner;

public class CountSum {
	public static void main(String[] args) {
		System.out.println("请输入一个整数:");
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		double sum = 0;
		double count_nine = 0;
		for (int i = 1; i <= count; i++) {
			count_nine = Math.pow(10.0, i) - 1;
			sum += count_nine;
			System.out.println(count_nine);
		}
		System.out.println("Sum is " + sum);
	}
}

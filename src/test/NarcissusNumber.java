package test;

import java.util.Scanner;

public class NarcissusNumber {
	public static void main(String[] args) {
		System.out.println("查找1到所设数字范围内的所有水仙花数字:");
		System.out.println("请输入范围的最大值:");
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
		int number;
		int sum;
		int isZero;
		int k = 0;
		boolean isBreak = false;
		for (int i = 1; i <= max; i++) {
			sum = 0;
			number = i;
			do {
				k = number % 10;
				sum += (k * k * k);
				isZero = number / 10;
				if (isZero == 0) {
					isBreak = true;
				} else {
					number = number / 10;
				}
			} while (!isBreak);
			if (sum == i)
				System.out.println(i + " ");
			isBreak = false;
		}
	}
}

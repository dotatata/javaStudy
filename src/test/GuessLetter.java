package test;

import java.util.Arrays;
import java.util.Scanner;

public class GuessLetter {
	public static void main(String[] args) {
		System.out.println("欢迎尝试猜字母游戏!");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入想猜的字符个数:");
		char[] result = generate(sc.nextInt());
		System.out.println(Arrays.toString(result));
		System.out.println("请输入答案:");
		String answer = "";
		int successNum = 0;
		int checkNum = 0;
		do {
			answer = sc.next();
			checkNum += 1;
			successNum = check(result, answer);
			System.out.println("尝试" + checkNum + "次,回答正确" + successNum + "个字符");
		} while (successNum != result.length);
		System.out.println("恭喜你回答正确!");
	}

	// 生成答案函数
	public static char[] generate(int x) {
		char[] result = new char[x];
		int randomNum;
		for (int i = 0; i < result.length; i++) {
			randomNum = (int) (Math.random() * 25) + 97;
			result[i] = (char) randomNum;
		}
		return result;
	}

	// 检查答案
	public static int check(char[] result, String answer) {
		char[] a = answer.toCharArray();
		int successNum = 0;
		if (a.length < result.length) {
			return -1;
		}
		for (int i = 0; i < result.length; i++) {
			if (result[i] == a[i])
				successNum += 1;
		}
		return successNum;
	}
}

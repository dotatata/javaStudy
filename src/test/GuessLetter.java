package test;

import java.util.Arrays;
import java.util.Scanner;

public class GuessLetter {
	public static void main(String[] args) {
		System.out.println("��ӭ���Բ���ĸ��Ϸ!");
		Scanner sc = new Scanner(System.in);
		System.out.println("��������µ��ַ�����:");
		char[] result = generate(sc.nextInt());
		System.out.println(Arrays.toString(result));
		System.out.println("�������:");
		String answer = "";
		int successNum = 0;
		int checkNum = 0;
		do {
			answer = sc.next();
			checkNum += 1;
			successNum = check(result, answer);
			System.out.println("����" + checkNum + "��,�ش���ȷ" + successNum + "���ַ�");
		} while (successNum != result.length);
		System.out.println("��ϲ��ش���ȷ!");
	}

	// ���ɴ𰸺���
	public static char[] generate(int x) {
		char[] result = new char[x];
		int randomNum;
		for (int i = 0; i < result.length; i++) {
			randomNum = (int) (Math.random() * 25) + 97;
			result[i] = (char) randomNum;
		}
		return result;
	}

	// ����
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

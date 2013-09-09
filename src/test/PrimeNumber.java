package test;

public class PrimeNumber {
	public static void main(String[] args) {
		System.out.println("打印1~200的所有质数:");
		int j;
		int count=0;
		for (int i = 1; i <= 200; i++) {
			for (j = 2; j < i; j++) {
				if (i % j == 0) {
					break;
				}
			}
			if (i == j){
				System.out.println(i);
				count ++;
			}
		}
		System.out.println("共"+count+"个");
	}
}

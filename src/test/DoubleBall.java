package test;

public class DoubleBall {
	public static void main(String[] args) {
		int[] redBall = new int[32];
		for (int i = 0; i < 32; i++) {
			redBall[i] = i + 1;
		}
		int[] buleBall = { 1, 2, 3, 4, 5, 6, 7 };
		boolean[] flags = new boolean[32];
		int[] r = new int[7];
		// ѡ7������
		int index = -1;
		for (int i = 0; i < 7; i++) {
			do {
				index = (int) (Math.random() * 32);
			} while (flags[index]);
			r[i] = redBall[index];
			flags[index] = true;
		}
		// ѡ1������
		index = (int) (Math.random() * 7);
		System.out.println("���������:");
		System.out.println("����:");
		System.out.println(r[0] + "," + r[1] + "," + r[2] + "," + r[3] + ","
				+ r[4] + "," + r[5] + "," + r[6]);
		System.out.println("����:");
		System.out.println(buleBall[index]);
	}
}

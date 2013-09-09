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
		// 选7个红球
		int index = -1;
		for (int i = 0; i < 7; i++) {
			do {
				index = (int) (Math.random() * 32);
			} while (flags[index]);
			r[i] = redBall[index];
			flags[index] = true;
		}
		// 选1个蓝球
		index = (int) (Math.random() * 7);
		System.out.println("开奖结果是:");
		System.out.println("红球:");
		System.out.println(r[0] + "," + r[1] + "," + r[2] + "," + r[3] + ","
				+ r[4] + "," + r[5] + "," + r[6]);
		System.out.println("蓝球:");
		System.out.println(buleBall[index]);
	}
}

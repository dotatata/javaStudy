package test;

import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args){
		boolean[] arrayInt = new boolean[3];
		int[] arrayInt2 = new int[]{9,2,6};
		int[] arrayInt3 = {1,2,3};
		System.out.println(arrayInt.length+" "+arrayInt2.length);
		for(int i = 0;i<arrayInt.length;i++){
			arrayInt2[i] = arrayInt2[i]*10;
			System.out.println(arrayInt[i]);
			System.out.println(arrayInt3[i]);
		}
		System.out.println(Arrays.toString(arrayInt2));
		System.out.println(Arrays.equals(arrayInt2, arrayInt3));
		Arrays.sort(arrayInt2);
		System.out.println(Arrays.toString(arrayInt2));
		int[][] arrInt4 = {{32,43,64},{123,54,7},{65,23,8}};
		for(int i=0;i<arrInt4.length;i++){
			for(int j=0;j<arrInt4[i].length;j++){
				System.out.println(arrInt4[i][j]);
			}
		}
	}
}

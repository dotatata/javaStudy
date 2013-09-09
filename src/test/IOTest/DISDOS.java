package test.IOTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DISDOS {
	public static void main(String[] args) throws Exception {
		long time = System.currentTimeMillis();
		FileOutputStream fos = new FileOutputStream(FISFOS._DIR + "\\test2.txt");

		// 将一个数据(类型)输出到fos指定的资源中
		// 如果使用fos直接write()一个int型时 需要将该int拆为4个byte
		DataOutputStream dos = new DataOutputStream(fos);
		// int a = 888;
		// dos.write(a);
		// dos.writeInt(a);
		// dos.writeChars("xxxx");
		double r;
		for (int i = 0; i < 100; i++) {
			r = Math.random();
			// 写入的数据是dobule并不是String 所以用记事本打开是乱码
			dos.writeDouble(r);
			System.out.println(r);
		}
		dos.close();

		FileInputStream fis = new FileInputStream(FISFOS._DIR + "\\test2.txt");
		DataInputStream dis = new DataInputStream(fis);
		for (int i = 0; i < 100; i++) {
			// 写入的数据是dobule 所以用记事本打开是乱码
			r = dis.readDouble();
			// dis.readLine(); // 已弃用
			System.out.println("No." + i + " : " + r);
		}
		dis.close();
	}
}

package test.IOTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DISDOS {
	public static void main(String[] args) throws Exception {
		long time = System.currentTimeMillis();
		FileOutputStream fos = new FileOutputStream(FISFOS._DIR + "\\test2.txt");

		// ��һ������(����)�����fosָ������Դ��
		// ���ʹ��fosֱ��write()һ��int��ʱ ��Ҫ����int��Ϊ4��byte
		DataOutputStream dos = new DataOutputStream(fos);
		// int a = 888;
		// dos.write(a);
		// dos.writeInt(a);
		// dos.writeChars("xxxx");
		double r;
		for (int i = 0; i < 100; i++) {
			r = Math.random();
			// д���������dobule������String �����ü��±���������
			dos.writeDouble(r);
			System.out.println(r);
		}
		dos.close();

		FileInputStream fis = new FileInputStream(FISFOS._DIR + "\\test2.txt");
		DataInputStream dis = new DataInputStream(fis);
		for (int i = 0; i < 100; i++) {
			// д���������dobule �����ü��±���������
			r = dis.readDouble();
			// dis.readLine(); // ������
			System.out.println("No." + i + " : " + r);
		}
		dis.close();
	}
}

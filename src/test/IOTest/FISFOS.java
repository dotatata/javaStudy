package test.IOTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;

// ������������Ӧ�õĻ��� �󲿷�������FileInputStream/FileOutputStreamΪ��ʼ������
public class FISFOS {
	public static final String _DIR = "D:\\programming\\DEMO\\Java\\workspace\\HelloWorld\\src\\test\\IOTest\\test";

	public static void main(String[] args) throws Exception {
		long time = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream(_DIR + "\\test.zip");
		int b = -1;
		// ��ȡһ���ֽ�
		// int b = fis.read();
		// System.out.println(b);
		// fis.close();
		
		// �ļ�������ʱ ���������ļ�
		FileOutputStream fos = new FileOutputStream(_DIR + "\\test2.zip");
		while ((b = fis.read()) != -1) {
			fos.write(b);
		}
		fis.close();
		fos.close();
		time = System.currentTimeMillis() - time;
		System.out.println("copy finish;used" + time + "ms");
	}

}

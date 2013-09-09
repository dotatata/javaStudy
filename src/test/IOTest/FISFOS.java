package test.IOTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;

// 所有数据流类应用的基础 大部分流均以FileInputStream/FileOutputStream为初始化参数
public class FISFOS {
	public static final String _DIR = "D:\\programming\\DEMO\\Java\\workspace\\HelloWorld\\src\\test\\IOTest\\test";

	public static void main(String[] args) throws Exception {
		long time = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream(_DIR + "\\test.zip");
		int b = -1;
		// 读取一个字节
		// int b = fis.read();
		// System.out.println(b);
		// fis.close();
		
		// 文件不存在时 将创建该文件
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

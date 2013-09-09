package test.IOTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 字符转换流 一次 读出一个char/写入一个String
public class ISROSW {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream(FISFOS._DIR + "\\test.txt");
		InputStreamReader isr = new InputStreamReader(fis, "uft-8");
		
		// 文件需要是一个字符文件
		// 虽然isr.read()一次返回一个int 但是这个返回是一个填充int低八位的char
		int c = -1;
		while((c = isr.read()) != -1){
			System.out.println((char)c);
		}
		isr.close();
		
		FileOutputStream fos = new FileOutputStream(FISFOS._DIR + "/test2.txt");
		// 第二个参数指定写入文件的编码
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		osw.write("OutputStreamWriter!!");
		osw.close();
		System.out.println("写入完毕!!"+FISFOS._DIR + "/test2.txt");
	}
}

package test.IOTest;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;

public class PW {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream(FISFOS._DIR + "test/temp.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		PrintWriter pw = new PrintWriter(osw);
		// 把一个数据(类型)转成字符串输出
		Date date = new Date();
		pw.println(date);
		// pw.print(....);
		pw.close();
		
		// 修改System.out.println()的输出位置
		// 之后System.out.println()不再打印在控制台 而是打印在指定文件中
		System.setOut(new PrintStream(fos));
		System.out.println("hello world");
	}

}

package test.IOTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BRBW {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream(FISFOS._DIR + "\\test.txt");
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		// br只能连接字符流 isr/osr/FileReader/FileWriter
		BufferedReader br = new BufferedReader(isr);

		String str = null;
		// br.readLine()一次读取一行
		while((str = br.readLine()) != null){
			System.out.println(str);
		}
		
		br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		System.out.println(line.toUpperCase());
	}
}

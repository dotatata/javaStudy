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
		// ��һ������(����)ת���ַ������
		Date date = new Date();
		pw.println(date);
		// pw.print(....);
		pw.close();
		
		// �޸�System.out.println()�����λ��
		// ֮��System.out.println()���ٴ�ӡ�ڿ���̨ ���Ǵ�ӡ��ָ���ļ���
		System.setOut(new PrintStream(fos));
		System.out.println("hello world");
	}

}

package test.IOTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// �ַ�ת���� һ�� ����һ��char/д��һ��String
public class ISROSW {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream(FISFOS._DIR + "\\test.txt");
		InputStreamReader isr = new InputStreamReader(fis, "uft-8");
		
		// �ļ���Ҫ��һ���ַ��ļ�
		// ��Ȼisr.read()һ�η���һ��int �������������һ�����int�Ͱ�λ��char
		int c = -1;
		while((c = isr.read()) != -1){
			System.out.println((char)c);
		}
		isr.close();
		
		FileOutputStream fos = new FileOutputStream(FISFOS._DIR + "/test2.txt");
		// �ڶ�������ָ��д���ļ��ı���
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		osw.write("OutputStreamWriter!!");
		osw.close();
		System.out.println("д�����!!"+FISFOS._DIR + "/test2.txt");
	}
}

package test.IOTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

// FileReader/FileWriter�ǽ�(FIS+ISR)/(FOS+OSW)�ķ�װ���
// ������ϵͳ��Ĭ�ϱ��� ���Ҳ�������ָ�� ���Ե���Ҫָ������ʱ ����ʹ��FileReader/FileWriter
public class FRFW {
	public static void main(String[] args) throws Exception{
		// FileReader/FileWriterֻ������InputStreamReader/OutputStreamWriter���������
		// �����ڴ���������ʱ ֻ��ʹ��InputStreamReader/OutputStreamWriter
		URL url = new URL("www.baidu.com");
		InputStream is = url.openConnection().getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		int c = -1;
		while((c = isr.read()) != -1){
			System.out.println((char)c);
		}
	}
}

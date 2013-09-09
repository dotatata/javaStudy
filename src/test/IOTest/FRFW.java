package test.IOTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

// FileReader/FileWriter是将(FIS+ISR)/(FOS+OSW)的封装组合
// 编码是系统的默认编码 并且不能重新指定 所以当需要指定编码时 不能使用FileReader/FileWriter
public class FRFW {
	public static void main(String[] args) throws Exception{
		// FileReader/FileWriter只能算是InputStreamReader/OutputStreamWriter的特殊情况
		// 所以在打开网络连接时 只能使用InputStreamReader/OutputStreamWriter
		URL url = new URL("www.baidu.com");
		InputStream is = url.openConnection().getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		int c = -1;
		while((c = isr.read()) != -1){
			System.out.println((char)c);
		}
	}
}

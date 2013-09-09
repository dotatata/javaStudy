package test.IOTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class DownloadTest {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("address.txt");
		InputStreamReader is = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(is);
		String address = br.readLine().trim();
		
		URL url = new URL(address);
		// 网络流：和网络资源相连
		InputStream ism = url.openConnection().getInputStream();
		FileOutputStream fos = new FileOutputStream("download.zip");
		
		BufferedInputStream bis = new BufferedInputStream(ism);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int b = -1;
		while((b = bis.read()) != -1){
			bos.write(b);
		}
		bos.close();
		bis.close();
		System.out.println("Download finished!");
	}
}

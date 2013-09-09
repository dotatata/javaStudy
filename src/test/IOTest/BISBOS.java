package test.IOTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// 因为有缓冲区的概念 所以提高了读写效率
public class BISBOS {
	public static void main(String[] args) throws Exception {
		long time = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream(FISFOS._DIR+"\\test.txt");
		// 第二个参数表示是否将数据扩展添加入数据 true即为追加模型 false为覆盖模式
		FileOutputStream fos = new FileOutputStream(FISFOS._DIR+"\\test2.txt",false);
		
		// 只能和输入流相连
		BufferedInputStream bis = new BufferedInputStream(fis);
		// 只能和输出流相连
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		// bis.read()调用fis的read方法 一次充满bis的8k缓冲区(默认大小)
		// 并返回缓冲区的第一个字节
		// int b = bis.read();
		
		// bos.write(b)向bos的8k缓冲区(默认大小)写入一个字节
		// 缓冲区充满后一次性写入fos指定的资源
		// 如果没有充满缓冲区 则需要手动用flush方法将缓冲区推入资源
		// 关闭bos时 会自动flush
		// bos.write(b);
		
		int b = -1;
		while((b = bis.read()) != -1){
			bos.write(b);
		}
		bis.close();
		bos.close();
		
		time = System.currentTimeMillis() - time;
		System.out.println("copy finish;used" + time + "ms");
	}
}

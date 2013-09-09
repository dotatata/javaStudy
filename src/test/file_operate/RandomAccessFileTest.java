package test.file_operate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

// 只能访问文件 而不能访问别的(网络)资源
// 可以访问文件中的任意内容 而InputStream/OutputStream只能顺序读取文件内容
public class RandomAccessFileTest {
	private static final String DIRBASE = "src\\test\\file_operate\\";

	public static void main(String[] args) throws IOException {
		System.out.println("输入要创建的目录:");
		Scanner sc = new Scanner(System.in);
		String dirName = sc.next();
		File file = new File(DIRBASE + dirName);

		if (file.mkdir()) {
			System.out.println(dirName + "已创建");
		}

		System.out.println("输入在" + dirName + "要创建的文件:");
		String fileName = sc.next();
		file = new File(DIRBASE + dirName + "\\" + fileName);
		if (file.createNewFile()) {
			System.out.println(fileName + "已创建");
		}
		System.out.println("输入在" + fileName + "要输入的内容:");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		String content = sc.next();
		byte[] contentByte = content.getBytes();
		raf.write(contentByte);
		// raf.writeBytes(content);
		// raf.writeUTF(content);
		raf.close();
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] buf = new byte[(int)file.length()];
		fileInputStream.read(buf);
		content = new String(buf);
		System.out.println(content);
		fileInputStream.close();
	}
}

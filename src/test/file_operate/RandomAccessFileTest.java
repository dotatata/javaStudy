package test.file_operate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

// ֻ�ܷ����ļ� �����ܷ��ʱ��(����)��Դ
// ���Է����ļ��е��������� ��InputStream/OutputStreamֻ��˳���ȡ�ļ�����
public class RandomAccessFileTest {
	private static final String DIRBASE = "src\\test\\file_operate\\";

	public static void main(String[] args) throws IOException {
		System.out.println("����Ҫ������Ŀ¼:");
		Scanner sc = new Scanner(System.in);
		String dirName = sc.next();
		File file = new File(DIRBASE + dirName);

		if (file.mkdir()) {
			System.out.println(dirName + "�Ѵ���");
		}

		System.out.println("������" + dirName + "Ҫ�������ļ�:");
		String fileName = sc.next();
		file = new File(DIRBASE + dirName + "\\" + fileName);
		if (file.createNewFile()) {
			System.out.println(fileName + "�Ѵ���");
		}
		System.out.println("������" + fileName + "Ҫ���������:");
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

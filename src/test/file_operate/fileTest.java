package test.file_operate;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class fileTest {
	public static final String DIRBASE = "src\\test\\file_operate\\";
	public static File file;
	public static File[] subFile;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("�����봴����Ŀ¼����:");
		String dirName = sc.next();
		// ����ļ�ϵͳ��û�д�Ŀ¼/�ļ�, ��file�����ʱ�����ڴ��� ��δ�������ļ�ϵͳ��
		File file1 = new File(DIRBASE + dirName);
		boolean isSuccess = false;
		// ����file1Ŀ¼
		if (!file1.exists()) {
			isSuccess = file1.mkdir();
			// isSuccess = file1.mkdirs();
		}
		if (isSuccess) {
			System.out.println("����Ŀ¼" + dirName + "(���·��)");
		} else {
			System.out.println("δ����Ŀ¼" + dirName + "(���·��) Ŀ¼�����Ѵ���;");
		}
		isSuccess = false;

		System.out.println("��������" + dirName + "�´������ļ�����:");
		String name = sc.next();
		File file2 = new File(file1, name);
		// File file3 = new File(DIRBASE + dirName, name);
		if (!file2.exists()) {
			try {
				isSuccess = file2.createNewFile();
			} catch (IOException e) {
				throw new IOException(e);
			}
		}
		if (isSuccess) {
			System.out.println("�����ļ�" + name);
		} else {
			System.out.println("δ�����ļ�" + name + " �ļ������Ѵ���;");
		}
		System.out.println("�ļ�" + file2 + "����Ϊ" + file2.length());

		checkDir();

		System.out.println("������Ҫɾ����Ŀ¼����:");
		String delName = sc.next();
		file = new File(DIRBASE + delName);
		subFile = file.listFiles();
		// String[] subFileStr = file.list();
		if (subFile.length > 0) {
			for (File f : subFile) {
				if (f.isDirectory() || f.isFile()) {
					if (f.delete()) {
						System.out.println("��ɾ��" + f);
					} else {
						System.out.println("δɾ��" + f);
					}
				} else {
					System.out.println(f + "����һ���ļ�����Ŀ¼");
				}
			}
		}
		if(file.delete()){
			System.out.println("��ɾ��" + delName);
		}else{
			System.out.println(delName + "����һ���ļ�����Ŀ¼");
		}

		checkDir();
	}

	public static void showDir(String delName) {
		file = new File(DIRBASE + delName);
		if (!file.exists()) {
			System.out.println(delName + "������;");
			return;
		}
		subFile = file.listFiles();
		if (subFile.length > 0) {
			for (File f : subFile) {
				System.out.println(f.toString());
			}
		}else{
			System.out.println(delName + "Ϊ��Ŀ¼");
		}
	}

	public static void checkDir() {
		String checkName;
		String isCheck = "yes";
		while ("yes".equalsIgnoreCase(isCheck)) {
			System.out.println("������Ҫ�鿴��Ŀ¼����(sr�鿴dirBase�µ�Ŀ¼):");
			checkName = sc.next();
			if ("sr".equalsIgnoreCase(checkName))
				checkName = "";
			showDir(checkName);
			System.out.println("����yes���²�ѯ;����noȡ����ѯ:");
			isCheck = sc.next();
		}
	}
}

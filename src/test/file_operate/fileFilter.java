package test.file_operate;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class fileFilter {
	public static final String DIRBASE = "src\\test\\file_operate\\";

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String dirName = "";
		File file;
		boolean isMkDir = false;
		while (!isMkDir) {
			System.out.println("������Ҫ������Ŀ¼:");
			dirName = sc.next();
			file = new File(DIRBASE + dirName);
			if (file.exists()) {
				System.out.println(dirName + "�Ѿ�����");
			} else {
				isMkDir = file.mkdir();
				System.out.println("����Ŀ¼" + dirName);
			}
		}

		String fileName = "";
		while (true) {
			System.out.println("������Ҫ��" + dirName + "�´������ļ�:");
			fileName = sc.next();
			file = new File(DIRBASE + dirName + "\\" + fileName);
			if (file.exists()) {
				System.out.println(fileName + "�Ѿ�����");
				continue;
			} else {
				file.createNewFile();
				System.out.println("�����ļ�" + fileName);
			}
			System.out.println("�Ƿ���������ļ�:Y/N");
			fileName = sc.next();
			if ("Y".equalsIgnoreCase(fileName)) {
				continue;
			} else {
				break;
			}
		}

		String filter;
		while (true) {
			System.out.println("������Ҫɸѡ���ļ���׺:");
			filter = sc.next();
			filterDir(dirName, filter);
			System.out.println("�Ƿ����ɸѡ�ļ�:Y/N");
			filter = sc.next();
			if ("Y".equalsIgnoreCase(filter)) {
				continue;
			} else {
				break;
			}
		}
	}

	// �ڲ�������ʹ�þֲ����� �ֲ���������Ϊfinal
	public static void filterDir(String dirName, final String filter) {
		File dir = new File(DIRBASE + dirName);
		File[] subfiles = dir.listFiles(new java.io.FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(filter);
			}
		});
		if (subfiles.length <= 0)
			System.out.println("��" + filter + "��׺�ļ�");
		for (File f : subfiles) {
			if (f.isDirectory() || f.isFile()) {
				System.out.println(f);
			} else {
				System.out.println(f + "����һ��Ŀ¼�����ļ�");
			}
		}
	}
}

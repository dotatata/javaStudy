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
			System.out.println("输入想要创建的目录:");
			dirName = sc.next();
			file = new File(DIRBASE + dirName);
			if (file.exists()) {
				System.out.println(dirName + "已经存在");
			} else {
				isMkDir = file.mkdir();
				System.out.println("创建目录" + dirName);
			}
		}

		String fileName = "";
		while (true) {
			System.out.println("输入想要在" + dirName + "下创建的文件:");
			fileName = sc.next();
			file = new File(DIRBASE + dirName + "\\" + fileName);
			if (file.exists()) {
				System.out.println(fileName + "已经存在");
				continue;
			} else {
				file.createNewFile();
				System.out.println("创建文件" + fileName);
			}
			System.out.println("是否继续创建文件:Y/N");
			fileName = sc.next();
			if ("Y".equalsIgnoreCase(fileName)) {
				continue;
			} else {
				break;
			}
		}

		String filter;
		while (true) {
			System.out.println("输入想要筛选的文件后缀:");
			filter = sc.next();
			filterDir(dirName, filter);
			System.out.println("是否继续筛选文件:Y/N");
			filter = sc.next();
			if ("Y".equalsIgnoreCase(filter)) {
				continue;
			} else {
				break;
			}
		}
	}

	// 内部匿名类使用局部变量 局部变量必须为final
	public static void filterDir(String dirName, final String filter) {
		File dir = new File(DIRBASE + dirName);
		File[] subfiles = dir.listFiles(new java.io.FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(filter);
			}
		});
		if (subfiles.length <= 0)
			System.out.println("无" + filter + "后缀文件");
		for (File f : subfiles) {
			if (f.isDirectory() || f.isFile()) {
				System.out.println(f);
			} else {
				System.out.println(f + "不是一个目录或者文件");
			}
		}
	}
}

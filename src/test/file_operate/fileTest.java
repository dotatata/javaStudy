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
		System.out.println("输入想创建的目录名称:");
		String dirName = sc.next();
		// 如果文件系统中没有此目录/文件, 则file对象此时均在内存中 并未创建在文件系统中
		File file1 = new File(DIRBASE + dirName);
		boolean isSuccess = false;
		// 创建file1目录
		if (!file1.exists()) {
			isSuccess = file1.mkdir();
			// isSuccess = file1.mkdirs();
		}
		if (isSuccess) {
			System.out.println("创建目录" + dirName + "(相对路径)");
		} else {
			System.out.println("未创建目录" + dirName + "(相对路径) 目录可能已存在;");
		}
		isSuccess = false;

		System.out.println("输入想在" + dirName + "下创建的文件名称:");
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
			System.out.println("创建文件" + name);
		} else {
			System.out.println("未创建文件" + name + " 文件可能已存在;");
		}
		System.out.println("文件" + file2 + "长度为" + file2.length());

		checkDir();

		System.out.println("输入想要删除的目录名称:");
		String delName = sc.next();
		file = new File(DIRBASE + delName);
		subFile = file.listFiles();
		// String[] subFileStr = file.list();
		if (subFile.length > 0) {
			for (File f : subFile) {
				if (f.isDirectory() || f.isFile()) {
					if (f.delete()) {
						System.out.println("已删除" + f);
					} else {
						System.out.println("未删除" + f);
					}
				} else {
					System.out.println(f + "不是一个文件或者目录");
				}
			}
		}
		if(file.delete()){
			System.out.println("已删除" + delName);
		}else{
			System.out.println(delName + "不是一个文件或者目录");
		}

		checkDir();
	}

	public static void showDir(String delName) {
		file = new File(DIRBASE + delName);
		if (!file.exists()) {
			System.out.println(delName + "不存在;");
			return;
		}
		subFile = file.listFiles();
		if (subFile.length > 0) {
			for (File f : subFile) {
				System.out.println(f.toString());
			}
		}else{
			System.out.println(delName + "为空目录");
		}
	}

	public static void checkDir() {
		String checkName;
		String isCheck = "yes";
		while ("yes".equalsIgnoreCase(isCheck)) {
			System.out.println("输入想要查看的目录名称(sr查看dirBase下的目录):");
			checkName = sc.next();
			if ("sr".equalsIgnoreCase(checkName))
				checkName = "";
			showDir(checkName);
			System.out.println("输入yes重新查询;输入no取消查询:");
			isCheck = sc.next();
		}
	}
}

package test.file_operate;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileUtilTest {
	public static List<File> list = new ArrayList<File>();
	private static final String _DIR = "D:\\programming\\DEMO\\Java\\workspace\\HelloWorld\\src\\test\\file_operate\\";
	public static void main(String[] args) throws IOException {
		System.out.println("本测试默认基础目录为:" + _DIR);
		System.out.println("输入要创建的目录名：(输入skip跳过创建目录)");
		Scanner sc = new Scanner(System.in);
		String newFileStr = sc.next();
		File newDir = new File(_DIR+newFileStr);
		if(!"skip".equalsIgnoreCase(newFileStr)){
			if(!newDir.exists()){
				newDir.mkdir();
				System.out.println(newDir.getPath()+"已经创建");
			}else{
				System.out.println(newDir.getPath()+"已经存在");
			}
		}
		
		File newFileDir;
		while(true){
			System.out.println("输入要创建的文件名：(输入skip完成创建)");
			newFileStr = sc.next();
			newFileDir = new File(newDir.getPath() + "\\" + newFileStr);
			if("skip".equalsIgnoreCase(newFileStr))
				break;
			if(newFileDir.exists()){
				System.out.println(newDir.getPath()+"已经存在");
			}else{
				newFileDir.createNewFile();
			}
		}
		String[] postfixStrArr = new String[3];
		String tempStr;
		int time = 0;
		while(true){
			tempStr = "";
			for(String postfix:postfixStrArr){
				if(postfix != null)
					tempStr = tempStr +";"+ postfix;
			}
			System.out.println("输入需要筛选的后缀:(最多输入3个;输入skip完成)"+tempStr);
			String postfixStr = sc.next();
			if ("skip".equalsIgnoreCase(postfixStr) || time == 3){
				break;
			}
			postfixStrArr[time] = postfixStr;
			time++;
		}
		System.out.println("输入想要筛选的目标目录路径:");
		String dirStr = sc.next();
		List<File> fileList = listFile(dirStr, postfixStrArr);
		if(fileList != null){
			Iterator<File> i = fileList.iterator();
			while(i.hasNext()){
				File tempFile = i.next();
				System.out.println(tempFile.getPath()+":"+tempFile.getName());
			}
		}
	}
	
	//获取dir指定目录及其子目录下指定扩展名names的文件
	public static List<File> listFile(String dirStr, final String[] names){
		dirStr = _DIR + dirStr; 
		File dir = new File(dirStr);
		//路径存在 且为一个目录
		if(!dir.exists()||!dir.isDirectory()){
			return list;
		}
		File[] fileArr = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if(pathname.isDirectory()){
					return true;
				}else{
					for(String name:names){
						if(pathname.getName().endsWith(name))
							return true;
					}
					return false;
				}
			}
		});
		for(File file:fileArr){
			if(file.isFile()){
				list.add(file);
			}else{
				List<File> subList = listFile(file.getPath(), names);
				list.addAll(subList);
			}
		}
		return list;
	}
}

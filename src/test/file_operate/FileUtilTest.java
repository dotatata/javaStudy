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
		System.out.println("������Ĭ�ϻ���Ŀ¼Ϊ:" + _DIR);
		System.out.println("����Ҫ������Ŀ¼����(����skip��������Ŀ¼)");
		Scanner sc = new Scanner(System.in);
		String newFileStr = sc.next();
		File newDir = new File(_DIR+newFileStr);
		if(!"skip".equalsIgnoreCase(newFileStr)){
			if(!newDir.exists()){
				newDir.mkdir();
				System.out.println(newDir.getPath()+"�Ѿ�����");
			}else{
				System.out.println(newDir.getPath()+"�Ѿ�����");
			}
		}
		
		File newFileDir;
		while(true){
			System.out.println("����Ҫ�������ļ�����(����skip��ɴ���)");
			newFileStr = sc.next();
			newFileDir = new File(newDir.getPath() + "\\" + newFileStr);
			if("skip".equalsIgnoreCase(newFileStr))
				break;
			if(newFileDir.exists()){
				System.out.println(newDir.getPath()+"�Ѿ�����");
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
			System.out.println("������Ҫɸѡ�ĺ�׺:(�������3��;����skip���)"+tempStr);
			String postfixStr = sc.next();
			if ("skip".equalsIgnoreCase(postfixStr) || time == 3){
				break;
			}
			postfixStrArr[time] = postfixStr;
			time++;
		}
		System.out.println("������Ҫɸѡ��Ŀ��Ŀ¼·��:");
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
	
	//��ȡdirָ��Ŀ¼������Ŀ¼��ָ����չ��names���ļ�
	public static List<File> listFile(String dirStr, final String[] names){
		dirStr = _DIR + dirStr; 
		File dir = new File(dirStr);
		//·������ ��Ϊһ��Ŀ¼
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

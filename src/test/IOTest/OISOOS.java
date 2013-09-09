package test.IOTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OISOOS {
	public static void main(String[] args) throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		FileOutputStream fos = new FileOutputStream(FISFOS._DIR + "\\test.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		// 可以写入文件的类 必须是可以序列化的 也就是类中必须实现了序列化接口Serializable
		// 因为在将文件中的类读出时 原来的类有可能出现修改的情况 
		// 所以必须实现序列化 说明具体的序列化的逻辑 以避免了类修改的情况
		oos.writeObject(list);
		oos.close();
	}
}
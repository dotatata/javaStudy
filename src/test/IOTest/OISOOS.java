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
		// ����д���ļ����� �����ǿ������л��� Ҳ�������б���ʵ�������л��ӿ�Serializable
		// ��Ϊ�ڽ��ļ��е������ʱ ԭ�������п��ܳ����޸ĵ���� 
		// ���Ա���ʵ�����л� ˵����������л����߼� �Ա��������޸ĵ����
		oos.writeObject(list);
		oos.close();
	}
}
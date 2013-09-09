package test.IOTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// ��Ϊ�л������ĸ��� ��������˶�дЧ��
public class BISBOS {
	public static void main(String[] args) throws Exception {
		long time = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream(FISFOS._DIR+"\\test.txt");
		// �ڶ���������ʾ�Ƿ�������չ��������� true��Ϊ׷��ģ�� falseΪ����ģʽ
		FileOutputStream fos = new FileOutputStream(FISFOS._DIR+"\\test2.txt",false);
		
		// ֻ�ܺ�����������
		BufferedInputStream bis = new BufferedInputStream(fis);
		// ֻ�ܺ����������
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		// bis.read()����fis��read���� һ�γ���bis��8k������(Ĭ�ϴ�С)
		// �����ػ������ĵ�һ���ֽ�
		// int b = bis.read();
		
		// bos.write(b)��bos��8k������(Ĭ�ϴ�С)д��һ���ֽ�
		// ������������һ����д��fosָ������Դ
		// ���û�г��������� ����Ҫ�ֶ���flush������������������Դ
		// �ر�bosʱ ���Զ�flush
		// bos.write(b);
		
		int b = -1;
		while((b = bis.read()) != -1){
			bos.write(b);
		}
		bis.close();
		bos.close();
		
		time = System.currentTimeMillis() - time;
		System.out.println("copy finish;used" + time + "ms");
	}
}

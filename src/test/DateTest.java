package test;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateTest {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		// �����·ݱ���Ϊ��дMM
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
		String dateStr = sdf.format(date);
		System.out.println(dateStr);
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		dateStr = sdf.format(date);
		System.out.println(dateStr);
	}
}

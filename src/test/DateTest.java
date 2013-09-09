package test;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateTest {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		// 参数月份必须为大写MM
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String dateStr = sdf.format(date);
		System.out.println(dateStr);
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		dateStr = sdf.format(date);
		System.out.println(dateStr);
	}
}

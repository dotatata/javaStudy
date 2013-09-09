package test.design_pattern;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SingletonClass {
	private final static SingletonClass instance = new SingletonClass();
	
	public SingletonClass(){
	}
	
	public static SingletonClass getInstance(){
		return instance;
	}
	
	public static Date stringToDate(String str) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date date = sdf.parse(str);
		String s = "ssssss";
		byte[] b = s.getBytes();
		return date;
	}
}

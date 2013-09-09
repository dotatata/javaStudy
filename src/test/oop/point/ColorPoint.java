package test.oop.point;

public class ColorPoint extends Point {
	public String color = new String();
	public ColorPoint(String msg){
		super(msg);
		color = msg;
	}
	// 重写java对象基类的toString()方法
	public String toString(){
		return color;
	}
}

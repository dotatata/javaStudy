package test.oop.point;

public class ColorPoint extends Point {
	public String color = new String();
	public ColorPoint(String msg){
		super(msg);
		color = msg;
	}
	// ��дjava��������toString()����
	public String toString(){
		return color;
	}
}

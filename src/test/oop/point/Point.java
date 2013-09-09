package test.oop.point;

public class Point {
	public int x;
	public int y;
	public Point(){
		System.out.println("This is the Point!");
	}
	public Point(String msg){
		System.out.println("This the Point, and created by overload with a parameter of String:\"" + msg + "\".");
	}
}

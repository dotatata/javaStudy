package test.oop;

import test.oop.point.*;

public class OopTest {
	public static void main(String[] args) {
		// 无参数构造
		Point point = new Point();
		// 构造方法重载
		point = new Point("Point");

		// 子类调用父类构造方法
		ColorPoint colorPoint = new ColorPoint("RedPoint");
		System.out.println(colorPoint.toString());

		if (getInstanceof(point)) {
			System.out.println("true");
			ColorPoint colorPointWithConvert = (ColorPoint) point;
			colorPointWithConvert.color = "convert Point to ColorPoint";
			System.out.println(colorPointWithConvert.toString());
		} else {
			point = new ColorPoint("Bule");
			System.out.println(point.toString());
		}
		point = new FirstQuadrantPoint();
		
		Person p = new Person("xxx");
		Person p1 = new Chinese("xxx");
		// p1虽然指向的对象虽然是Chinese 但是变量类型是Person 
		// 没有sayChinese方法 所以下面一句代码是编译错误
		// p1.sayChinese("I am xxx");
		Chinese c = new Chinese("xxx");
		c.sayChinese("I am xxx");
		c.saySomething();
	}

	public static boolean getInstanceof(Point point) {
		// 父类的引用可以通过instanceof(操作符)与子类比较
		// 多用于进行强制转换前判断 否则强制转换失败会出运行时异常
		return point instanceof ColorPoint;
	}
}

// 子类可以调用父类的方法 为了安全调用父类的方法
// 所以子类的构造方法中首先需要super() 这保证了父类初始化的安全 也就保证了调用父类方法时的安全
// 如果父类中有无参数构造方法时 则说明父类中的方法 安全性并不依赖初始化
// 所以子类中的构造方法可以不用super()
class Person {
	public String name;

	// 当父类中没有定义无参数构造方法时
	// 子类中的构造方法第一行必须为super()
	// Person(){
	// this.name = "anonymity";
	// }
	Person(String name) {
		this.name = name;
	}
	
	public void saySomething(){
		System.out.println("say something");
	}
}

class Chinese extends Person {
	public int age;

	// Chinese(){}
	Chinese(String name) {
		super(name);
	}

	Chinese(String name, int age) {
		super(name);
		this.age = age;
	}
	
	public void sayChinese(String words){
		System.out.println(words);
	}
}

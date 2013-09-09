package test.oop;

import test.oop.point.*;

public class OopTest {
	public static void main(String[] args) {
		// �޲�������
		Point point = new Point();
		// ���췽������
		point = new Point("Point");

		// ������ø��๹�췽��
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
		// p1��Ȼָ��Ķ�����Ȼ��Chinese ���Ǳ���������Person 
		// û��sayChinese���� ��������һ������Ǳ������
		// p1.sayChinese("I am xxx");
		Chinese c = new Chinese("xxx");
		c.sayChinese("I am xxx");
		c.saySomething();
	}

	public static boolean getInstanceof(Point point) {
		// ��������ÿ���ͨ��instanceof(������)������Ƚ�
		// �����ڽ���ǿ��ת��ǰ�ж� ����ǿ��ת��ʧ�ܻ������ʱ�쳣
		return point instanceof ColorPoint;
	}
}

// ������Ե��ø���ķ��� Ϊ�˰�ȫ���ø���ķ���
// ��������Ĺ��췽����������Ҫsuper() �Ᵽ֤�˸����ʼ���İ�ȫ Ҳ�ͱ�֤�˵��ø��෽��ʱ�İ�ȫ
// ������������޲������췽��ʱ ��˵�������еķ��� ��ȫ�Բ���������ʼ��
// ���������еĹ��췽�����Բ���super()
class Person {
	public String name;

	// ��������û�ж����޲������췽��ʱ
	// �����еĹ��췽����һ�б���Ϊsuper()
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

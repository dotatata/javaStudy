package test.Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import test.DateTest;

interface China {
	public static final String name = "Rollen";
	public static int age = 20;

	public void sayChina();

	public void sayHello(String name, int age);
}

class Person implements China {
	private String name;
	private String sex;

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void sayChina() {
		System.out.println("hello ,china");
	}

	public void sayHello(String name, int age) {
		System.out.println(name + " " + age);
		if (age < -1) {
			sayFuck(this.name);
		}
	}

	private void sayFuck(String name) {
		System.out.println(name + " says: Fuck!");
	}

	public String toString() {
		return name + " is " + sex;
	}
}

public class ClassTest {
	public static void main(String[] args) {
		int x = 0;
		Class<?> demo = null;
		try {
			demo = Class.forName("test.Class.Person");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ȡ��ȫ������
		Field[] field = demo.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			// Ȩ�����η�
			int mo = field[i].getModifiers();
			String priv = Modifier.toString(mo);
			// ��������
			Class<?> type = field[i].getType();
			System.out.println(priv + " " + type.getName() + " "
					+ field[i].getName() + ";");
		}
		// ��ȡ���췽��
		Constructor<?> cons[] = demo.getConstructors();
		for (int i = 0; i < cons.length; i++) {
			System.out.println("���췽����  " + cons[i]);
		}
		// ʵ����Person
		Person per1 = null;
		Person per2 = null;
		// ���Person����ֻ��һ�����캯�� �����ֱ��ʵ�������� ���������б�͹��캯����ͬ:
		// per1 = (Person) demo.newInstance();
		try {
			for (int i = 0; i < cons.length; i++) {
				if (cons[i].getParameterTypes().length == 1) {
					per1 = (Person) cons[i].newInstance("Rollen");
					x = i;
				} else {
					per2 = (Person) cons[i].newInstance("Rollen", "male");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(per1.toString());
		System.out.println(per2.toString());
		// �������еĽӿ�
		Class<?> intes[] = demo.getInterfaces();
		for (int i = 0; i < intes.length; i++) {
			System.out.println("ʵ�ֵĽӿ�   " + intes[i].getName());
		}
		// ȡ�ø���
		Class<?> parent = demo.getSuperclass();
		System.out.println("�̳еĸ���Ϊ��   " + parent.getName());

		// ��Person�ķ���
		try {
			Method method = demo.getMethod("sayHello", String.class, int.class);
			// sayHello�Ĳ����б���һ������ ����invoke������Ҫһ��ʵ����Ϊ���� ����Ҫһ����������Ϊ�����ĵ��ò���
			method.invoke(cons[x].newInstance("zyk"), "Java", 27);
			// ����private���� getMethod�Ƿ���public���� getDeclaredMethod�Ƿ������з���
			method = demo.getDeclaredMethod("sayFuck", String.class);
			method.setAccessible(true);
			// sayFuck�Ĳ����б���һ������ ����invoke������Ҫһ��ʵ����Ϊ���� ����Ҫһ����������Ϊ�����ĵ��ò���
			method.invoke(cons[x].newInstance("zyk"), "Java");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
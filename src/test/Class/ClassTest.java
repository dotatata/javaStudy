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
		// 取得全部属性
		Field[] field = demo.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			// 权限修饰符
			int mo = field[i].getModifiers();
			String priv = Modifier.toString(mo);
			// 属性类型
			Class<?> type = field[i].getType();
			System.out.println(priv + " " + type.getName() + " "
					+ field[i].getName() + ";");
		}
		// 获取构造方法
		Constructor<?> cons[] = demo.getConstructors();
		for (int i = 0; i < cons.length; i++) {
			System.out.println("构造方法：  " + cons[i]);
		}
		// 实例化Person
		Person per1 = null;
		Person per2 = null;
		// 如果Person类中只有一个构造函数 则可以直接实例化对象 方法参数列表和构造函数相同:
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
		// 保存所有的接口
		Class<?> intes[] = demo.getInterfaces();
		for (int i = 0; i < intes.length; i++) {
			System.out.println("实现的接口   " + intes[i].getName());
		}
		// 取得父类
		Class<?> parent = demo.getSuperclass();
		System.out.println("继承的父类为：   " + parent.getName());

		// 调Person的方法
		try {
			Method method = demo.getMethod("sayHello", String.class, int.class);
			// sayHello的参数列表是一个参数 所以invoke除了需要一个实例作为参数 还需要一个参数的作为方法的调用参数
			method.invoke(cons[x].newInstance("zyk"), "Java", 27);
			// 调用private方法 getMethod是返回public方法 getDeclaredMethod是返回所有方法
			method = demo.getDeclaredMethod("sayFuck", String.class);
			method.setAccessible(true);
			// sayFuck的参数列表是一个参数 所以invoke除了需要一个实例作为参数 还需要一个参数的作为方法的调用参数
			method.invoke(cons[x].newInstance("zyk"), "Java");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
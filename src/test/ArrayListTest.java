package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("PersonInstance");
		list.add("PersonInstance1");
		ArrayList<Person> arrList = new ArrayList<Person>();
		arrList.add(new Person("Ken", 18));
		arrList.add(new Person("Peter", 23));
		arrList.add(new Person("Jenny", 19, "female"));
		arrList.add(new Person("Tom", 21));
		// ArrayList的toString()方法重写为依次调用集合中对象的toString()方法
		System.out.println(arrList.toString() + "\n" + "Arraylist长度为"
				+ arrList.size());
		System.out.println(arrList + "\n" + "Arraylist长度为" + arrList.size());
		// ArrayList的sort方法需要元素对象实现Comparable接口
		// sort方法为依次调用对象实现的Comparable接口的compareTo方法
		Collections.sort(arrList);
		System.out.println(arrList);
		// sort方法接受一个匿名Comparator<T>接口类 并在其中实现compare方法
		// 则集合元素依次回调compare方法进行sort排序
		// 两种排序都需要自己定义排序的逻辑 包括控制正序逆序的逻辑
		// 返回1 参与比较的两对象会被交换位置 返回-1 参与比较的两对象不会被交换位置
		Collections.sort(arrList, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.age > o2.age)
					return -1;
				else if (o1.age < o2.age)
					return 1;
				else
					return 0;
			}
		});
		System.out.println(arrList);
		// ArrayList的contains()/remove()方法为依次调用集合中对象的equals()方法
		// contains()方法返回boolean值 remove()方法返回boolean值并删除对象
		boolean isDel = false;
		Person person = new Person("Peter");
		if (arrList.contains(person)) {
			isDel = arrList.remove(person);
		}
		System.out.println(arrList.toString() + "\n" + "Arraylist长度为"
				+ arrList.size());
		if (isDel)
			System.out.println("已删除" + person.toString());
		// 所有的Collection的实现类都实现了迭代器接口
		// 每次next方法调用完后只能调用一次remove方法(删除next返回的对象)
		// 迭代过程中不能调用集合的remove方法 否则ConcurrentModificationException
		Iterator<Person> arrListIter = arrList.iterator();
		Person temp;
		while (arrListIter.hasNext()) {
			temp = arrListIter.next();
			if ("Tom".equals(temp.name)) {
				arrListIter.remove();
				System.out.println("已删除" + temp.toString());
			}
		}
		System.out.println(arrList.toString() + "\n" + "Arraylist长度为"
				+ arrList.size());
		// 增强型for循环语句
		for (Person p : arrList) {
			System.out.println(p);
		}
		// subList方法返回指定两下标之间的集合(包含起始下标对象 不包含结束下标对象)
		// 该子集合元素和原集合元素占有相同的内存空间 所以对其中一者的操作会影响另一者
		List<Person> subArrList = arrList.subList(0, 2);
		System.out.println(subArrList);
		// 通过subList可以删除指定区间内的对象
		// arrList.subList(0,2).clear();
	}
}

class Person implements Comparable<Person> {
	String name;
	int age = 0;
	String sex = "male";

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String toString() {
		return name + " " + age + " " + sex;
	}

	// 重写equals方法注意方法参数类型需为Object
	// 涉及字符串对比应使用字符串的equals方法
	@Override
	public boolean equals(Object person) {
		if (this.name.equals(((Person) person).name))
			return true;
		else
			return false;
	}

	// 实现Comparable接口的compareTo方法
	// 注意:对象相等时 应该和equals方法一致
	@Override
	public int compareTo(Person o) {
		char i = this.name.toUpperCase().charAt(0);
		char j = o.name.toUpperCase().charAt(0);
		if (i > j)
			return 1;
		else if (i < j)
			return -1;
		else
			return 0;
	}
}

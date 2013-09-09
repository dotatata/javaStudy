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
		// ArrayList��toString()������дΪ���ε��ü����ж����toString()����
		System.out.println(arrList.toString() + "\n" + "Arraylist����Ϊ"
				+ arrList.size());
		System.out.println(arrList + "\n" + "Arraylist����Ϊ" + arrList.size());
		// ArrayList��sort������ҪԪ�ض���ʵ��Comparable�ӿ�
		// sort����Ϊ���ε��ö���ʵ�ֵ�Comparable�ӿڵ�compareTo����
		Collections.sort(arrList);
		System.out.println(arrList);
		// sort��������һ������Comparator<T>�ӿ��� ��������ʵ��compare����
		// �򼯺�Ԫ�����λص�compare��������sort����
		// ����������Ҫ�Լ�����������߼� ������������������߼�
		// ����1 ����Ƚϵ�������ᱻ����λ�� ����-1 ����Ƚϵ������󲻻ᱻ����λ��
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
		// ArrayList��contains()/remove()����Ϊ���ε��ü����ж����equals()����
		// contains()��������booleanֵ remove()��������booleanֵ��ɾ������
		boolean isDel = false;
		Person person = new Person("Peter");
		if (arrList.contains(person)) {
			isDel = arrList.remove(person);
		}
		System.out.println(arrList.toString() + "\n" + "Arraylist����Ϊ"
				+ arrList.size());
		if (isDel)
			System.out.println("��ɾ��" + person.toString());
		// ���е�Collection��ʵ���඼ʵ���˵������ӿ�
		// ÿ��next�����������ֻ�ܵ���һ��remove����(ɾ��next���صĶ���)
		// ���������в��ܵ��ü��ϵ�remove���� ����ConcurrentModificationException
		Iterator<Person> arrListIter = arrList.iterator();
		Person temp;
		while (arrListIter.hasNext()) {
			temp = arrListIter.next();
			if ("Tom".equals(temp.name)) {
				arrListIter.remove();
				System.out.println("��ɾ��" + temp.toString());
			}
		}
		System.out.println(arrList.toString() + "\n" + "Arraylist����Ϊ"
				+ arrList.size());
		// ��ǿ��forѭ�����
		for (Person p : arrList) {
			System.out.println(p);
		}
		// subList��������ָ�����±�֮��ļ���(������ʼ�±���� �����������±����)
		// ���Ӽ���Ԫ�غ�ԭ����Ԫ��ռ����ͬ���ڴ�ռ� ���Զ�����һ�ߵĲ�����Ӱ����һ��
		List<Person> subArrList = arrList.subList(0, 2);
		System.out.println(subArrList);
		// ͨ��subList����ɾ��ָ�������ڵĶ���
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

	// ��дequals����ע�ⷽ������������ΪObject
	// �漰�ַ����Ա�Ӧʹ���ַ�����equals����
	@Override
	public boolean equals(Object person) {
		if (this.name.equals(((Person) person).name))
			return true;
		else
			return false;
	}

	// ʵ��Comparable�ӿڵ�compareTo����
	// ע��:�������ʱ Ӧ�ú�equals����һ��
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

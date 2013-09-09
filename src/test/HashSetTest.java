package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		Random r = new Random();
		int i = 0;
		while (set.size() <= 10) {
			set.add(r.nextInt(50));
			i++;
		}
		System.out.println(set);
		System.out.println("i = " + i);
		// Set集合遍历需要使用迭代器
		Iterator<Integer> setIter = set.iterator();
		while (setIter.hasNext()) {
			System.out.println(setIter.next());
		}
		System.out.println("******************************");
		for (Integer j : set) {
			System.out.println(j);
		}
		Set<PersonHash> setHash = new HashSet<PersonHash>();
		setHash.add(new PersonHash("Tom"));
		// HashSet集合调用contains方法 
		// 需要先调用对象本身以及参数的HashCode方法进行判断
		// 如果HashCode方法返回相同 再调用对象本身的equals方法进行判断
		// 所以存入HashSet的对象 需要重写HashCode方法
		if (setHash.contains(new PersonHash("Tom"))) {
			setHash.remove(new PersonHash("Tom"));
			System.out.println("Tom is existed.");
		} else {
			System.out.println("Tom is not existed.");
		}
		System.out.println(setHash.size());
	}
}

class PersonHash extends Person {
	public PersonHash(String name) {
		super(name);
	}

	@Override
	public int hashCode() {
		// return super.hashCode();
		int result = 1;
		result = 88 * result + nameHashCode();
		result = 88 * result + age;
		return result;
	}

	private int nameHashCode() {
		int sum = 0;
		for (int i = 0; i < name.length(); i++) {
			sum += name.charAt(i);
		}
		return sum;
	}
}

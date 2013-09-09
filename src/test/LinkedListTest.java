package test;

import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		// 队列
		Queue<Person> queue = new LinkedList<Person>();
		queue.add(new Person("Ken"));
		queue.offer(new Person("Peter"));
		queue.offer(new Person("Jenny"));
		queue.offer(new Person("Tom"));
		System.out.println(queue);
		// 返回队首元素
		System.out.println(queue.peek());
		// 返回队首元素 并在队列中删除此元素
		System.out.println(queue.poll());
		System.out.println(queue);
		// 栈
		System.out.println("*****************");
		Deque<Person> deque = new LinkedList<Person>();
		int queueSize = queue.size();
		for (int i = 0; i < queueSize; i++) {
			deque.push(queue.poll());
		}
		System.out.println(deque);
		while(deque.peek()!=null){
			System.out.println(deque.pop());
		}
		// 迭代器之于队列和栈就没有特别的意义
		// 因为队列和栈的逻辑特殊
		System.out.println("**********");
		Iterator<Person> queueIter = queue.iterator();
		while(queueIter.hasNext()){
			System.out.println(queueIter.next());
		}
	}
}
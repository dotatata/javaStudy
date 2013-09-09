package test;

import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		// ����
		Queue<Person> queue = new LinkedList<Person>();
		queue.add(new Person("Ken"));
		queue.offer(new Person("Peter"));
		queue.offer(new Person("Jenny"));
		queue.offer(new Person("Tom"));
		System.out.println(queue);
		// ���ض���Ԫ��
		System.out.println(queue.peek());
		// ���ض���Ԫ�� ���ڶ�����ɾ����Ԫ��
		System.out.println(queue.poll());
		System.out.println(queue);
		// ջ
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
		// ������֮�ڶ��к�ջ��û���ر������
		// ��Ϊ���к�ջ���߼�����
		System.out.println("**********");
		Iterator<Person> queueIter = queue.iterator();
		while(queueIter.hasNext()){
			System.out.println(queueIter.next());
		}
	}
}
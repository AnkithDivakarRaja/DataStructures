package org.learning.queues;

import java.util.Stack;

public class Queue1 {

	public static void main(String[] args) {
		
		Queue q = new Queue();
		
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}
}

class Queue{
	
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	
	void enQueue(int element) {
		
		s1.push(element);
		
	}
	
	int deQueue() {
		if(s2.isEmpty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
}
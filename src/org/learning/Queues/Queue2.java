package org.learning.Queues;

import java.util.*;

public class Queue2 {

	public static void main(String[] args) {
		
		StackWith2Queues s = new StackWith2Queues();
		
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop());
		System.out.println(s.pop());

	}

}

class StackWith2Queues{
	
	java.util.Queue<Integer> q1 = new LinkedList<>();
	java.util.Queue<Integer> q2 = new LinkedList<>();
	
	void push(int data) {
		
		if(q1.isEmpty()) {
			q2.add(data);			
		}else
			q1.add(data);
		
	}
	
	int pop() {
		
		if(q1.isEmpty()) {
			int size = q2.size();
			
			for(int i=0; i<size - 1 ; i++) {
				q1.add(q2.poll());
			}
			return q2.poll();
		}else {
			int size = q1.size();
			
			for(int i=0; i<size - 1 ; i++) {
				q2.add(q1.poll());
			}
			return q1.poll();
		}
		
	}
	
}

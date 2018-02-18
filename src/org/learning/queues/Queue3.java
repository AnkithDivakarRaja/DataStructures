package org.learning.queues;

import java.util.LinkedList;
import java.util.Stack;

public class Queue3 {

	public static void main(String[] args) {
		

		java.util.Queue<Integer> q = new LinkedList<>();
		
		q.add(11);
		q.add(12);
		q.add(13);
		q.add(14);
		q.add(15);
		q.add(16);
		q.add(17);
		q.add(18);
		q.add(19);
		q.add(20);
		
		Queue3 qObj = new Queue3();
		qObj.interLeavingQueue(q);
		
		for(int i: q) {
			System.out.println(i);
		}
		
	}
	
	void interLeavingQueue(java.util.Queue<Integer> que) {
		
		Stack<Integer> s = new Stack<>();
		
		int halfSize = que.size()/2;
		
		for(int i=0; i<halfSize; i++)
			s.push(que.poll());
		
		while(!s.isEmpty()) {
			que.add(s.pop());
			for(int i=0;i<halfSize; i++) {
				que.add(que.poll());
			}
		}
		for(int i=0;i<halfSize; i++) {
			s.push(que.poll());
		}
		while(!s.isEmpty()) {
			que.add(s.pop());
			que.add(que.poll());
		}
	}

}

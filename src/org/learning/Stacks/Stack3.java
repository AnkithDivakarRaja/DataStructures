package org.learning.Stacks;

import java.util.Stack;

public class Stack3 {

	void reverseStack(Stack<Integer> s) {
		if(s.isEmpty()) return;
		
		int tmp = s.pop();
		reverseStack(s);
		insetAtBottom(s, tmp);
	}
	
	private void insetAtBottom(Stack<Integer> s, int data) {
		if(s.isEmpty()) {
			s.push(data);
			return;
		}
		int tmp = s.pop();
		insetAtBottom(s, data);
		s.push(tmp);
	}
	
	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<>();
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		
		Stack3 st3 = new Stack3();
		
		st3.reverseStack(s);
		
		for(int i : s) {
			System.out.println(i);
		}

	}

}

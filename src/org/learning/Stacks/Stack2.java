package org.learning.stacks;

import java.util.Stack;

public class Stack2 {

	static Stack<Integer> s = new Stack<>();
	static Stack<Integer> minStack = new Stack<>();
	
	static int getMinimum() {
		 return minStack.peek();
	}
	
	static int pop() {
		
		if(s.peek() == minStack.peek()) {
			minStack.pop();
			return s.pop();
		}else {
			return s.pop();
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] nums = {6,2,8,1,-67,3,7,1,6,8};
		int min = Integer.MAX_VALUE;
		for(int num: nums) {
			s.push(num);
			if(num <= min) {
				min = num;
				minStack.push(num);
			}
		}
		
		System.out.println("The minimum number in the array is " + getMinimum());
		System.out.println("Min stack size is " + minStack.size());

	}

}

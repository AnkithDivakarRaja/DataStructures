package org.learning.Stacks;

import java.util.Stack;

public class Stack4 {

	int evaluateExpression(String[] exp) {
		Stack<Integer> s = new Stack();
		for(String str: exp) {
			if(str.equals("+")) {
				int op1 = s.pop();
				int op2 = s.pop();
				s.push(op1 + op2);
			}else if(str.equals("-")) {
				int op1 = s.pop();
				int op2 = s.pop();
				s.push(op2 - op1);
			}else if(str.equals("*")) {
				int op1 = s.pop();
				int op2 = s.pop();
				s.push(op1 * op2);
			}else if(str.equals("/")) {
				int op1 = s.pop();
				int op2 = s.pop();
				s.push(op2 / op1);
			}else {
				s.push(Integer.parseInt(str));
			}
		}
		return s.pop();
	}
	
	public static void main(String[] args) {
		
		Stack4 st4 = new Stack4();
		
		String[] exp = {"1","2","3","*","+","5","-"};
		
		System.out.println(st4.evaluateExpression(exp));
		
		

	}

}

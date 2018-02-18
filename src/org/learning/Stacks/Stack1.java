package org.learning.Stacks;

import java.util.Stack;

public class Stack1 {

	String infixToPostfix(String exp) {
		
		StringBuilder result = new StringBuilder();
		
		Stack<Character> s = new Stack<>();
		
		for(int i=0; i<exp.length(); i++) {
			char c = exp.charAt(i);
			
			if(Character.isLetterOrDigit(c))
				result.append(c);
			else if(c == '(')
				s.push(c);
			else if(c == ')') {
				while(!s.isEmpty() && s.peek() != '(')
					result.append(s.pop());
				
				if(!s.isEmpty() && s.peek() != '(')
					System.out.println("Invalid Expression ");
				else
					s.pop();
			} else {
				while(!s.isEmpty() && prec(c) <= prec(s.peek()) ) {
					result.append(s.pop()); 
				}
				s.push(c);
			}
		}
		
		while(!s.isEmpty())
			result.append(s.pop());
		
		return result.toString();
	}
	
	int prec(char op) {
		switch(op) {
		case '+':
		case '-': return 1;
		case '*':
		case '/': return 2;
		case '^': return 3;
		default: return -1;
		
		}
	}
	
	public static void main(String[] args) {
		
		Stack1 s = new Stack1();
		
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(s.infixToPostfix(exp));

	}

}

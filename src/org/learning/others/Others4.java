package org.learning.others;

public class Others4 {

	public static void main(String[] args) {
		
		Others4 o = new Others4();
		
		o.printParanthesis(new char[20], 4, 0, 0, 0);

	}
	
	void printParanthesis(char[] str, int n, int pos, int open, int close){
		
		if(close == n) {
			for(Character c:str) {
				System.out.print(c);
			}
			System.out.println();
		}else {
			if(open > close) {
				str[pos] = '}';
				printParanthesis(str, n, pos + 1, open, close + 1);
			}
			if(open < n) {
				str[pos] = '{';
				printParanthesis(str, n, pos + 1, open + 1, close);
			}
		}
		
		
	}

}

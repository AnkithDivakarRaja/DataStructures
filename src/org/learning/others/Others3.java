package org.learning.others;

public class Others3 {

	static int count(String a, String b) {
		
		if(a.length() < b.length()) {
			
			int first = b.indexOf(a);
			int last = b.lastIndexOf(a);
			
			if(first == -1 || last == -1) return -1;
			
			int count = (last - first + a.length())/a.length();
			
			if(a.contains(b.substring(0, first))) {
				count++;
			}
			if(a.contains(b.substring(last + a.length()))) {
				count++;
			}
			return count;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		String a = "abcd";
		String b = "cdabcdabcdab";
		
		System.out.println(count(a,b));
	}

}

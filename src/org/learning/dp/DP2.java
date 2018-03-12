package org.learning.dp;

import java.util.ArrayList;

public class DP2 {

	public static void main(String[] args) {
		
		DP2 dp = new DP2();
		
		ArrayList<String> perm = dp.getPerms("ab");

		for(String s : perm) System.out.println(s);
	}

	ArrayList<String> getPerms(String str){
		
		ArrayList<String> result = new ArrayList<>();
		
		getPerms("" , str, result);
		
		return result;
		
	}
	
	void getPerms(String prefix, String remainder, ArrayList<String> results) {
		
		if(remainder.length() == 0) results.add(prefix);
		
		int len = remainder.length();
		for(int j=0; j< len; j++) {
			String before = remainder.substring(0, j);
			String after = remainder.substring(j+1, len);
			char c = remainder.charAt(j);
			getPerms(prefix + c, before + after, results);
		}
		
	}
	
}

package org.learning.dp;

import java.util.*;

public class DP1 {

	int lcs(char[] X, char[] Y, int m, int n) {
		
		HashSet<Character> hs = new HashSet<>();
		int[][] L = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0 || j==0) L[i][j] = 0;
				else if(X[i-1] == Y[j-1]) {
					L[i][j] = L[i-1][j-1] + 1;
					hs.add(X[i-1]);
				}
				else L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
			}
		}
		
		for(int[] i:L) {
			for(int j:i)
				System.out.print(j);
			System.out.println();
		}
		
		Iterator<Character> i = hs.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
			
	 return L[m][n];	
	}
	
	public static void main(String[] args) {
		
		DP1 dp = new DP1();
		
		String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
	 
	    char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	 
	    System.out.println("Length of LCS is" + " " +
	                                  dp.lcs( X, Y, m, n ) );
		
	}

}

package org.learning.dp;

import java.util.Arrays;

public class DP3 {

	int capacity = 10;
	
	public static void main(String[] args) {
		
		DP3 dp = new DP3();
		
		int[] songLength = {3,2,5,6,1,4,2,2,4,5};
		
		int [][] table = dp.generateMinSongLength(songLength);

		for(int[] row : table ) {
			for(int element : row) {
				if(element == 2147483647)
					System.out.print(0 + "  ");
				else
					System.out.print( element + "  " );
			}
			System.out.println();
		}
		
	}

	int[][] generateMinSongLength(int[] l){
		
		int[][] minLength = new int[l.length+1][l.length+1];
		
		for(int i=0; i<l.length + 1; i++) {
			Arrays.fill(minLength[i], Integer.MAX_VALUE);
		}
		
		for(int i=0; i<l.length; i++) {
			for(int j=i; j<l.length; j++) {
				
				if(i==0 || j==0) minLength[i][j] = 0;
				
				
				int uptillLastSong = minLength[i+1][j];
				
				//wasted space calculation is wrong
				int wastedSpace = (minLength[i][j] % capacity != 0 && minLength[i][j] % capacity - capacity >= l[j])? 0: capacity - minLength[i][j] % capacity;// : 0;
				
				int withCurrentSong = l[j] + minLength[i][j] + wastedSpace;
				
				minLength[i+1][j+1] = Math.min(uptillLastSong ,  withCurrentSong); 
				
			}
		}
		
		return minLength;
	}
	
}

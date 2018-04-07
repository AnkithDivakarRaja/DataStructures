package org.learning.dp;

import java.util.Arrays;

public class DP3 {

	int capacity = 8;
	int[][] minLength;
	int[][] songSelection;
	
	public static void main(String[] args) {
		
		DP3 dp = new DP3();
		
		//int[] songLength = {3,2,5,6,1,4,2,2,4,5};
		int[] songLength = {3,2,3,6,1,4,2};
		
		dp.generateMinSongLength(songLength);
		dp.selectedSongs(2, songLength);
		
	}

	//Generate min length table
	int[][] generateMinSongLength(int[] l){
		
		minLength = new int[l.length+1][l.length+1];
		songSelection = new int[l.length+1][l.length+1];
		// 0 excluded
		// 1 included
		
		for(int i=0; i<l.length + 1; i++) {
			Arrays.fill(minLength[i], Integer.MAX_VALUE);
			Arrays.fill(songSelection[i], Integer.MAX_VALUE);
		}
		
		for(int i=0; i<l.length; i++) {
			for(int j=i; j<l.length; j++) {
				
				if(i==0 || j==0) minLength[i][j] = 0;
				
				
				int uptillLastSong = minLength[i+1][j];
				
				int withCurrentSong = 0;
				//remaining space in the current CD
				int space = capacity - minLength[i][j] % capacity;
				
				if(space < l[j]) {
					withCurrentSong = l[j] + minLength[i][j] + space;
				}else {
					withCurrentSong = l[j] + minLength[i][j];
				}
				
				if(withCurrentSong < uptillLastSong) {
					minLength[i+1][j+1] = withCurrentSong;
					songSelection[i+1][j+1] = 1;
				}else {
					minLength[i+1][j+1] = uptillLastSong;
					songSelection[i+1][j+1] = 0;
				}
				
				minLength[i+1][j+1] = Math.min(uptillLastSong ,  withCurrentSong); 
				
			}
		}
		
		//print minLength
		System.out.println("Min length table");
		printTable(minLength);
		
		//print selection table
		System.out.println("Song selection table");
		printTable(songSelection);
		
		return minLength;
	}
	
	//Print selected songs
	void selectedSongs(int noOfCds, int[] songLength) {
		
		int totalCapacity = noOfCds*capacity;
		int maxSongs = 0;
		int leftSongs = minLength.length;
		
		finish:
		for(int i=minLength.length - 1; i>0; i--) {
			for(int j=minLength[i].length - 1; j>i; j--) {
				if(minLength[i][j] <= totalCapacity) {
					maxSongs = i;
					System.out.println("Total number of songs is " + maxSongs);
					break finish;
				}
			}
		}
		
		//Song to CD mapping
		int tmp = capacity;
		while(maxSongs > 0 && leftSongs > 0) {
			if(songSelection[maxSongs][leftSongs-1] == 1) {
				
				if(tmp < songLength[leftSongs - 2]) {
					tmp = capacity;
					noOfCds--;	
				}
				System.out.println("Song " + (leftSongs - 1) + " included in CD " + noOfCds);
				tmp -= songLength[leftSongs - 2];
				
				maxSongs--;
			}
			leftSongs--;
		}
		
	}
	
	
	//utility class
	void printTable(int[][] table) {
		
		for(int[] row : table ) {
			for(int element : row) {
				if(element == 2147483647)
					System.out.print(9 + "  ");
				else
					System.out.print( element + "  " );
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	
}

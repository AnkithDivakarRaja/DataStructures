package org.learning.others;

import java.util.Arrays;

public class Others2 {

	static void print3sum(int num[], int sum) {
		
		Arrays.sort(num);
		
		for(int i = 0; i<num.length - 2; i++) {
			
			int l = i + 1;
			int r = num.length - 1;
			
			while(l<r) {
				if(num[i] + num[l] + num[r] == sum) {
					System.out.println("i" + num[i]);
					System.out.println("l" + num[l]);
					System.out.println("r" + num[r]);
					break;
				}else if(num[i] + num[l] + num[r] < sum) {
					l++;
				}else {
					r--;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		int A[] = {1, 4, 45, 6, 10, 8};
	    int sum = 22;

	    print3sum(A, sum);
	}

}

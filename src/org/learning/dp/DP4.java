package org.learning.dp;

public class DP4 {

	public static void main(String[] args) {
		
		DP4 dp = new DP4();

		int[] start = {1,3,6,2};
		int[] end = {2,5,19,100};
		int[] weight = {50,20,100,200};
		
		System.out.println(dp.getMaxWeightActivity(start, end, weight, 0, 0));
 		
	}
	
	int getMaxWeightActivity(int[] start, int[] end, int[] weight, int index, int lastEnd) {
		
		if(index < start.length) {
			
			if(lastEnd > start[index]) {
				return getMaxWeightActivity(start, end, weight, index + 1, lastEnd);
			}else {
				return Math.max(weight[index] + getMaxWeightActivity(start, end, weight, index + 1, end[index]), getMaxWeightActivity(start, end, weight, index + 1, lastEnd));
			}
		}
		return 0;
	}

}

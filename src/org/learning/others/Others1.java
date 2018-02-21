package org.learning.others;

public class Others1 {

	static int maxProfit(int[] closingPrice) {
		
		int high = closingPrice[0];
		int low = closingPrice[0];
		
		int maxProfit = closingPrice[0];
		
		for(int i=0; i<closingPrice.length; i++) {
			
			if(closingPrice[i] < low) {
				low = closingPrice[i];
			}else if(closingPrice[i] - low > maxProfit){
				
				high = closingPrice[i];
				maxProfit = closingPrice[i] - low;
			}
		}
		
		return maxProfit;
	}
	
	
	public static void main(String[] args) {
		
		int[] aapl = {12, 56, 11, 78, 89, 67, 34, 12, 104, 89};
	
		System.out.print("Max profit :");
		System.out.println(maxProfit(aapl));
	}
}

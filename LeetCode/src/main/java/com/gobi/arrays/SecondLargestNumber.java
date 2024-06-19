package com.gobi.arrays;

public class SecondLargestNumber {

	public static void main(String[] args) {
		int[] arr = { 5,2,3,4,5 };
		 
		int high = 0;
		int secHigh = 0;
 
		for (int i = 0; i < arr.length; i++) {
 
			if (arr[i] > high) {
				secHigh = high;
				high = arr[i];
			} else if (arr[i] > secHigh && high > arr[i]) {
				secHigh = arr[i];
			}
		}
		
		System.out.println(secHigh);
	
	}

}

package com.gobi.arrays;

import java.util.Arrays;

public class MIssingNumber {

	public static void main(String[] args) {
		int[] arr={10,9,8,7,6,4,3,1,2};
		
		int sum = 0;
		int n = arr.length + 1;
		for(int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		int missingNum = (((n * (n + 1))/2) - sum);
		System.out.println(missingNum);
		
		//Approach : 2
		Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]+1!=arr[i+1])
            {
                System.out.println(arr[i]+1);
                break;
            }
        }
	}

}

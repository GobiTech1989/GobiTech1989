package com.gobi.arrays;

import java.util.Arrays;

public class ReverseTheArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		
		int length = nums.length;
		int begin = 0, end = length - 1;
		
		while (begin < end) {
			int temp = nums[begin];
			nums[begin] = nums[end];
			nums[end] = temp;
			begin++;
			end--;
		}
		
		System.out.println(Arrays.toString(nums));

	}

}

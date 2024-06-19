package com.gobi.arrays;

import java.util.Arrays;

public class RotateTheArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		int k = 2;
		
		int length = nums.length;
		k = k % length;
		if (k < 0) {
			k = k + length;
		}
		
		//Using O(n)
		reverse(nums, 0, length -1);
		reverse(nums, 0, k-1);
		reverse(nums, k, length -1);
		
		System.out.println(Arrays.toString(nums));
		
	}
	
	static void reverse(int[] nums, int begin, int end) {
		while (begin < end) {
			int temp = nums[begin];
			nums[begin] = nums[end];
			nums[end] = temp;
			begin++;
			end--;
		}
	}

}

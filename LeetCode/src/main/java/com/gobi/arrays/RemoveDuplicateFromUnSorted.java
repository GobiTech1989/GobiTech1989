package com.gobi.arrays;

public class RemoveDuplicateFromUnSorted {

	public static void main(String[] args) {
		int[] nums = {1,2,4,3,3,4,1,5};
		int length = nums.length;
		
		for (int i = 0; i < length; i++) {
			
			if (nums[i] != -1) {
				for (int j = i + 1; j < length; j++) {
					
					if (nums[i] == nums[j]) {
						nums[j] = -1;
					}
				}
				System.out.println(nums[i]);
			}
		}
		
	}

}

package com.gobi.arrays;

public class RemoveDuplicateFromSorted {

	public static void main(String[] args) {
		int[] nums = {1,2,2,2,3,3,4,4,5};
		int j = removeDuplicate(nums);
		
		for (int i = 0; i < j; i++) {
			System.out.println(nums[i]);
		}

	}

	private static int removeDuplicate(int[] nums) {
		int length = nums.length;
		int j = 0;
		
		for (int i = 1; i < length; i++) {
			if (nums[j] != nums[i]) {
				j++;
				nums[j] = nums[i];
			}
		}
		return j + 1;
	}
}

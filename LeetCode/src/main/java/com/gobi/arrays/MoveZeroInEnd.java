package com.gobi.arrays;

import java.util.Arrays;

public class MoveZeroInEnd {

	public static void main(String[] args) {
		// How To Move Zeroes To End Of An Array
		int[] nums = {1,0,13,0,2};
		
		
		int length = nums.length;
		
		if(length == 0 || length == 1) return;
		
		int nz = 0, z =0;
		
		while(nz < length) {
			
			if (nums[nz] != 0) {
				swap(nums,z,nz);
				nz++;
				z++;
			} else {
				nz++;
			}
		}
		
		System.out.println(Arrays.toString(nums));
	}
	
	public static void swap(int[] nums, int z, int nz) {
		int temp = nums[nz];
		nums[nz] = nums[z];
		nums[z] = temp;
	}

}

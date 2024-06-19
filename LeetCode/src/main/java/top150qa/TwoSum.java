package top150qa;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] nums = {3,2,3};
		int target = 6;
		int[] result = ts.twoSum(nums, target);
		
		System.out.println(Arrays.toString(result));
	}
	
	public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{};
        
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
        	for (int j = i+1; j < n; j++) {
	        	if (nums[i] + nums[j] == target) {
	        		return new int[]{i,j};
	        	}
        	}
        }
        return new int[]{};	
    }

}

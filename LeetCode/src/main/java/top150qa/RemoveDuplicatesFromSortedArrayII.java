package top150qa;

public class RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		int size = removeDuplicates(nums);

		for (int i = 0; i < size; i++) {
			System.out.print(nums[i]+" ");
		}

	}
	
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		
		int indexCount = 2;
	    for (int i = 2; i < nums.length; i++) {
	        if (nums[i] != nums[indexCount-2]) {
	            nums[indexCount++] = nums[i];
	        }
	    }
	    return indexCount;  
    }

}

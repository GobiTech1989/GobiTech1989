package top150qa;

public class JumpGame {

	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		boolean canJump = canJump(nums);
		System.out.println(canJump);
	}
	
	public static boolean canJump(int[] nums) {
		int lastPos = nums.length - 1;
		
		for (int i = nums.length - 1; i>= 0; i--) {
			if (i + nums[i] >= lastPos) {
				lastPos  = i;
			}
		}
		
		return lastPos == 0;
	}

}

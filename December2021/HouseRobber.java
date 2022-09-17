class Solution {
	// TC : O(n)

	public int rob(int[] nums) {
		if(nums.length==0) {
			return 0;
		} else if(nums.length==1) {
			return nums[0];
		}
		else if(nums.length==2) {
			return Math.max(nums[0], nums[1]);
		}
		else {

			int[] dp = new int[nums.length];
			dp[0]=nums[0];
			dp[1]= nums[1];
			dp[2]= nums[0]+nums[2];
			int max = Math.max(dp[2], dp[1]);
			for(int i=3;i<nums.length;i++){

				dp[i]=  Math.max(dp[i-2], dp[i-3]) + nums[i];
				max = Math.max(dp[i], max);
			}


			return max;
		}
	}
}
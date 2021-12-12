class Solution {
	// TC : O(total*nums.length)
	// SC : O(total*nums.length)
	public boolean canPartition(int[] nums) {
		// sum equal to nums/2
		Arrays.sort(nums);
		int totalSum = 0;
		for(int el: nums){
			totalSum +=el;
		}
		if(totalSum % 2 != 0){
			return false;
		}

		// 0 total/2
		boolean[][] dp = new boolean[nums.length+1][totalSum/2+1];

		for(int i=0;i<dp.length;i++){
			dp[i][0] = true;
		}

		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				dp[i][j] = dp[i-1][j]; // excluding the current el
				if(j>=nums[i-1]){
					dp[i][j] = dp[i][j]  || dp[i-1][j-nums[i-1]];
				}
			}
		}

		return dp[nums.length][totalSum/2];
	}
}
class Solution {
	// Tc: O(n)
	// SC : O(n)
	public int deleteAndEarn(int[] nums) {
		int[] freq = new int[10002];
		int[] dp = new int[10002];

		for(int i = 0; i < nums.length; i++){
			freq[nums[i]]++;
		}

		dp[0] = 0;
		dp[1] = 1* freq[1];
		for(int i = 2; i < 10002; i++){
			dp[i] = Math.max(dp[i-1], dp[i-2] + i * freq[i]);
		}
		return dp[10001];
	}
}
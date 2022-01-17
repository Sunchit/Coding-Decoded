class Solution {
	// TC : O(n)
	// SC:  O(n)
	public long mostPoints(int[][] questions) {
		long[] dp = new long[questions.length];

		for(int i=questions.length-1;i>=0;i--){
			int furtureReachIndex = i + questions[i][1] +1;
			if(furtureReachIndex<questions.length){
				dp[i] = dp[furtureReachIndex] + questions[i][0];
			} else {
				dp[i] = questions[i][0];
			}

			if(i<questions.length-1) {
				// skip the ith index
				dp[i] = Math.max(dp[i+1], dp[i]);
			}
		}
		return dp[0];

	}
}
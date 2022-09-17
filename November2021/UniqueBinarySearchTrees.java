class Solution {
	// TC : O(n2)
	private int[] dp = new int[20];
	public int numTrees(int n) {

		if(n <= 1) return 1;
		if(dp[n]>0) return dp[n];
		for(int i = 1; i <= n; i++)
			dp[n] += numTrees(i-1) * numTrees(n-i);
		return dp[n];

	}

}
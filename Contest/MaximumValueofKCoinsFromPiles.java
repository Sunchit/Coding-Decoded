class Solution {
	private Integer dp[][];

	public int maxValueOfCoins(List<List<Integer>> piles, int k) {
		int n = piles.size();
		dp = new Integer[n+1][k+1];
		return knapsack(piles, piles.size()-1, k);
	}

	private int knapsack(List<List<Integer>>piles, int i, int k){
		if(i < 0 || k == 0) return 0;

		if(dp[i][k] != null) return dp[i][k];

		int n = Math.min(piles.get(i).size(), k);

		int exclude = knapsack(piles, i-1, k);

		int include = 0;
		for(int j=0, sum=0; j<n; j++){
			sum += piles.get(i).get(j);
			include = Math.max(sum + knapsack(piles, i-1, k-j-1), include);
		}

		int res = Math.max(include, exclude);

		dp[i][k] = res;
		return res;
	}


}
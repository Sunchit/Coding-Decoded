class Solution {
	private int mod = 1000000007;

	public int numberOfWays(int s, int e, int k) {
		int[][] dp = new int[3002][1001];

		for(int[] item : dp){
			Arrays.fill(item, -1);
		}
		return topDownApproach(s, e, s, k, dp);
	}

	private int topDownApproach(int s, int e, int curr, int k, int[][] dp){

		if(k == 0){
			if(curr == e) { return 1; }
			else { return 0; }
		}

		if(dp[curr+1001][k] != -1){
			return dp[curr+1001][k];
		}
		// Move right
		int rightMove = topDownApproach(s, e, curr+1, k-1, dp)%mod;
		// Move Left
		int leftMove = topDownApproach(s, e, curr-1, k-1, dp)%mod;

		return dp[curr+1001][k] = (rightMove+leftMove)%mod;

	}


}


======== Approach using less memory ======
// https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/
// @author: anuj0503
class Solution {
    long[][] dp;
    int mod;
    public int numberOfWays(int startPos, int endPos, int k) {

        // dp[i][j] stores the number of ways to reach endPos from position i using k steps.
        dp = new long[startPos + k + 1][k + 1];
        // Intialise dp array with -1 to indicate that for current position i and step left k is not evaluated yet.
        for(int i = 0; i < startPos + k + 1; i++) Arrays.fill(dp[i], -1);
        
        
        // If startPos - k is less than 0, means our current are going negative. Since we will reduce it at most by k times.
        // so shift startPos and endPos by difference between startPos and endPosition so that max we can go 0 by reducing k times.
        if(startPos < k){
            int diff = k - startPos;
            startPos += diff;
            endPos += diff;
        }
        
        mod = 1000000007;

        getCount(startPos, endPos, k);
        
        if(dp[startPos][k] < 0) return 0;
        return (int)dp[startPos][k];
    }

    private long getCount(int currPos, int endPos, int k){
        if(k == 0){
            if(currPos == endPos){
                return 1;
            }
            return 0;
        }

        // If endPosition is out of reach or not possible from current position
        // using k steps, return 0.
        if(Math.abs(currPos - endPos) > k) return 0;
        
        if(dp[currPos][k] != -1) return dp[currPos][k];

        long ans = 0;
        ans = (ans + getCount(currPos + 1, endPos, k - 1)%mod)%mod;
        ans = (ans + getCount(currPos - 1, endPos, k - 1)%mod)%mod;
        
        dp[currPos][k] = ans;
        
        return dp[currPos][k];
    }
}

class Solution {
    // TC : O(n)
    // SC : O(n)
    private int[] dp = null;
    public int climbStairs(int n) {
        dp = new int[n+1];
        dp[1] = 1;
        if(n==1){
            return 1;
        }
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
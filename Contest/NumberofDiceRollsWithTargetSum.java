// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
// @author: anuj0503
class Solution {
    int[][] dp;
    int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n + 1][target + 1];

        for(int i = 0; i < n + 1; i++) Arrays.fill(dp[i], -1);
        
        return getRollCount(n, k, target);
    }

    private int getRollCount(int n, int k, int target){
        if(target < 0) return 0;
        if(n == 0 && target != 0) return 0;
        if(target == 0 && n != 0) return 0;

        if(n == 0 && target == 0) return 1;

        if(dp[n][target] != -1) return dp[n][target];

        long ans = 0;
        for(int i = 1; i <= k; i++){
            ans += getRollCount(n - 1, k, target - i);
        }

        dp[n][target] = (int)(ans%mod);
        
        return dp[n][target];
    }
}

// https://leetcode.com/problems/predict-the-winner/
// @author: @anuj0503
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        
        //DP[i][j] contains sum of number chosed by player (key pair because of both players).
        Pair<Integer, Integer>[][] dp = new Pair[n][n];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(i == j) dp[i][j] = new Pair<Integer, Integer>(nums[i], 0);
                else dp[i][j] = new Pair<Integer, Integer>(0, 0);
            }
        }
        
        // for each subarray of length l, we are finding the solution.
        for(int l = 2; l <= n; l++){
            for(int i = 0; i <= n - l; i++){
                int j = l + i - 1;
                
                Pair<Integer, Integer> pair = null;
                if(nums[i] + dp[i+1][j].getValue() > nums[j] + dp[i][j-1].getValue()){
                    pair = new Pair<>(nums[i] + dp[i+1][j].getValue(), dp[i+1][j].getKey());
                } else {
                    pair = new Pair<>(nums[j] + dp[i][j-1].getValue(), dp[i][j-1].getKey());
                }
                
                dp[i][j] = pair;
            }
        }
        
        return dp[0][n-1].getKey() >= dp[0][n-1].getValue();
    }
}

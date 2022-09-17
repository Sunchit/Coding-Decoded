// Recursion - TLE ❌
// TC: O(2^n)
// SC: O(n)
class Solution {
    public int minCostClimbingStairs(int[] cost) {        
        int zerothStair = helper(0, cost);
        int firstStair = helper(1, cost);
        
        return Math.min(zerothStair, firstStair);
    }
    
    private int helper(int ind, int[] cost) {
        // base case
        if (ind >= cost.length) {
            return 0;
        }
        
        int oneStep = cost[ind] + helper(ind + 1, cost);
        int twoStep = cost[ind] + helper(ind + 2, cost);
        
        return Math.min(oneStep, twoStep);
    }
}


// Memoization - Accepted ✅
// TC: O(n)
// SC: O(n) + O(n) -> stack space + dp array
class Solution {
    public int minCostClimbingStairs(int[] cost) {   
        int n = cost.length;
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        int zerothStair = helper(0, cost, dp);
        int firstStair = helper(1, cost, dp);
        
        return Math.min(zerothStair, firstStair);
    }
    
    private int helper(int ind, int[] cost, int[] dp) {
        // base case
        if (ind >= cost.length) {
            return 0;
        }
        
        if (dp[ind] != -1) {
            return dp[ind];
        }
        
        int oneStep = cost[ind] + helper(ind + 1, cost, dp);
        int twoStep = cost[ind] + helper(ind + 2, cost, dp);
        
        return dp[ind] = Math.min(oneStep, twoStep);
    }
}


// Tabulation - Accepted ✅
// TC: O(n)
// SC: O(n) -> dp array
class Solution {
    public int minCostClimbingStairs(int[] cost) {   
        int n = cost.length;
        
        int[] dp = new int[n];
        
        for (int ind = n - 1; ind >= 0; ind--) {
            int oneStep = cost[ind];
            if (ind + 1 < n) {
                oneStep += dp[ind + 1];
            }
            
            int twoStep = cost[ind];
            if (ind + 2 < n) {
                twoStep += dp[ind + 2];
            }
        
            dp[ind] = Math.min(oneStep, twoStep);
        }
        
        int zerothStair = dp[0];
        int firstStair = dp[1];
        
        return Math.min(zerothStair, firstStair);
    }    
}


// Tabulation + Space Optimization - Accepted ✅
// TC: O(n)
// SC: O(1)
class Solution {
    public int minCostClimbingStairs(int[] cost) {   
        int n = cost.length;
        
        int[] dp = new int[2];
        
        for (int ind = n - 1; ind >= 0; ind--) {
            int oneStep = cost[ind];
            if (ind + 1 < n) {
                oneStep += dp[(ind + 1) % 2];
            }
            
            int twoStep = cost[ind];
            if (ind + 2 < n) {
                twoStep += dp[(ind + 2) % 2];
            }
        
            dp[ind % 2] = Math.min(oneStep, twoStep);
        }
        
        int zerothStair = dp[0];
        int firstStair = dp[1];
        
        return Math.min(zerothStair, firstStair);
    }    
}

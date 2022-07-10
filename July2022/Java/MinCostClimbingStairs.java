
// @saorav21994
// TC : O(n)
// SC : O(1)

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n <= 2) return Math.min(cost[0], cost[1]);
        int [] dp = new int[n];
        int dp1 = cost[n-1];
        int dp2 = cost[n-2];
        
        for (int i = n-3; i >= 0; i--) {
            int dpTmp = cost[i] + Math.min(dp1, dp2);
            dp1 = dp2;
            dp2 = dpTmp;
        }
        return Math.min(dp1, dp2);
    }
}

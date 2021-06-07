class Solution {
    // TC : O(n)
    // SC : O(n) => 2
    public int minCostClimbingStairs(int[] cost) {

        // dp signifies cost to use each stair starting the zeroth index
        int[] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<cost.length;i++){

            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(
                dp[cost.length-2] , dp[cost.length-1]);
    }
}
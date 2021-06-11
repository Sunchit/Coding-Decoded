class Solution {

    // TC : O(n2)
    // SC : O(n2)
    // Top Down approach
    public int stoneGameVII(int[] stones) {

        int n = stones.length, sum = 0;

        int[][] dp = new int[n][n];

        for(int[] dpRow : dp)
            Arrays.fill(dpRow, -1);

        for(int stone: stones)
            sum += stone;

        return solve(0, n-1, stones, sum, dp);
    }

    public int solve(int left, int right, int[] stones, int sum, int[][] dp) {
        // Single element
        if(left == right)
            return 0;

        // 2 elements, pick up el for scone
        if(right - left == 1)
            return Math.max(stones[left], stones[right]);

        if(dp[left][right] != -1)
            return dp[left][right];

        int maxDiff = Math.max(sum - stones[left] - solve(left+1, right, stones, sum - stones[left], dp),
                sum - stones[right] - solve(left, right-1, stones, sum - stones[right], dp));

        dp[left][right] =  maxDiff;
        return maxDiff;
    }
}

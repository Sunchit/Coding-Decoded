class Solution {
    private int[][] dp;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        helper(piles, 0, n-1, true);
        return dp[0][piles.length-1] > 0;

    }

    public int helper(int[] piles, int left, int right, boolean alexTurn){
        if(left >= right){
            return 0;
        }

        if(dp[left][right] > 0){
            return dp[left][right];
        }

        if(alexTurn){ // If it is Alex's Turn
            int pickedLeft = helper(piles, left + 1, right, false) + piles[left];
            int  pickedRight = helper(piles, left,right - 1,false) + piles[right];
            dp[left][right] = Math.max(pickedLeft, pickedRight); // Storing the max ans at particular indices
            return dp[left][right];
        } else {    // If it is Lee's Turn
            int pickedLeft = helper(piles, left + 1, right, false) + piles[left];
            int  pickedRight = helper(piles, left,right - 1,false) + piles[right];
            dp[left][right] = Math.min(pickedLeft, pickedRight); // Storing the max ans at particular indices
            return dp[left][right];

        }
    }
}
// @saorav21994

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int l = matrix.length;
        if (l == 0)
            return 0;

        int [][] dp = new int[l][l];

        // copy first row to dp as it will be the start
        for (int i = 0; i < l; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < l; i++) {
            for (int j = 0; j < l; j++) {
                // top left
                int tl = (j-1 >= 0) ? dp[i-1][j-1] : Integer.MAX_VALUE;
                // top right
                int tr = (j+1 < l) ? dp[i-1][j+1] : Integer.MAX_VALUE;

                dp[i][j] = Math.min(Math.min(tl, tr), dp[i-1][j]) + matrix[i][j];

            }
        }

        // find min from last row

        int res = dp[l-1][0];
        for (int i = 1; i < l; i++) {
            res = Math.min(res, dp[l-1][i]);
        }

        return res;

    }
}

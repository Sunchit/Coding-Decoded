
// @saorav21994
// TC : O(no. of rows^2)
// SC : O(no. of rows^2)


class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double [][]dp = new double[102][102];
        dp[0][0] = (double) poured;
        for (int r = 0; r <= query_row; ++r) {
            for (int c = 0; c <= r; ++c) {
                double res = (dp[r][c] - 1.0) / 2.0;
                if (res > 0) {
                    dp[r+1][c] += res;
                    dp[r+1][c+1] += res;
                }
            }
        }
        return Math.min(1, dp[query_row][query_glass]);
    }
}




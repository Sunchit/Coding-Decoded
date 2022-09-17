// https://leetcode.com/problems/knight-probability-in-chessboard/
// @author: @anuj0503
class Solution {
    double[][][] dp;
    int count;
    int[][] moves;
    
    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[n][n][k+1];
        moves = new int[][]{{2, 1}, {-2, 1}, {-2, -1}, {2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
        double count = getCount(row, column, 0, n, k);
        
        return count;
    }
    
    private double getCount(int x, int y, int z, int n, int k){
        if(x < 0 || x >= n || y < 0 || y >= n) return 0;
        
        if(dp[x][y][z] != 0.0) return dp[x][y][z];
        
        if(z == k) return 1;
        
        double cnt = 0.0;
        for (int[] move : moves){
            // divide by 8 at each step instead of 8^k at the end.
            cnt += (getCount(x + move[0], y + move[1], z + 1, n, k)/8.0);
        }
        
        dp[x][y][z] = cnt;
        return cnt;
    }
}

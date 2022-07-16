
// @saorav21994
// TC : O(m*n*maxMove)
// SC : O(m*n*maxMove)

class Solution {
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer [][][] memo = new Integer[m][n][maxMove+1];     // Default -> null
        return find(m, n, maxMove, startRow, startColumn, memo);
    }
    
    public int find(int m, int n, int move, int i, int j, Integer [][][] memo) {
        int mod = 1000000007;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;       // we went outside the grid
        }
        if (move <= 0) {    // no more moves left
            return 0;
        }
        if (memo[i][j][move] != null) {
            return memo[i][j][move];    // memo already has this processed 
        }
        
        int count = 0;
        
        count = (count%mod) + (find(m, n, move-1, i-1, j, memo)%mod);
        count = (count%mod) + (find(m, n, move-1, i+1, j, memo)%mod);
        count = (count%mod) + (find(m, n, move-1, i, j-1, memo)%mod);
        count = (count%mod) + (find(m, n, move-1, i, j+1, memo)%mod);
        
        memo[i][j][move] = count%mod;
        
        return memo[i][j][move];
    }
}

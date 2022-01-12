class CherryPickerII {
    // TC : O(n*m*m)
    // SC : O(n*m*m)
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // i => Row index for both the robots
        // j1 => column index for 1st robot
        // j2 => column index for 2nd robot
        Integer[][][] dp = new Integer[n][m][m];

        return dfs(grid, n, m, 0, 0, m-1, dp);
    }

    private int dfs(int[][] grid, int n, int m, int r, int col1, int col2, Integer[][][] dp){
        if(r<0 || r>=n || col1 <0 || col1>=m || col2 <0 || col2>=m){
            return 0;
        }

        if(dp[r][col1][col2]!=null){
            return dp[r][col1][col2];
        }

        int maxCherries = 0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int newCol1 = col1 + i;
                int newCol2 = col2+ j;
                maxCherries = Math.max(maxCherries, dfs(grid, n, m, r+1,newCol1, newCol2, dp ));
            }
        }
        int currCherry = 0;
        if(col1 == col2){
            currCherry = grid[r][col1];
        } else {
            currCherry = grid[r][col1] + grid[r][col2];
        }

        dp[r][col1][col2] = currCherry + maxCherries;
        return dp[r][col1][col2];
    }
}
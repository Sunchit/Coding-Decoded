
// @saorav21994
// TC: O(R*C)
// SC: O(R*C)

class Solution {
    
    public int dfs(int [][]grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;     // marked as visited
        int ctr = 1;
        ctr += dfs(grid, i+1, j);
        ctr += dfs(grid, i, j+1);
        ctr += dfs(grid, i-1, j);
        ctr += dfs(grid, i, j-1);
        return ctr;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }
}

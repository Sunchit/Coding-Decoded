class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] vis = new boolean[m][n];
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0 && !vis[i][0]) {
                dfs(i, 0, grid, vis, dx, dy);                
            }
            if (grid[i][n - 1] == 0 && !vis[i][n - 1]) {
                dfs(i, n - 1, grid, vis, dx, dy);
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0 && !vis[0][j]) {
                dfs(0, j, grid, vis, dx, dy);
            }
            if (grid[m - 1][j] == 0 && !vis[m - 1][j]) {
                dfs(m - 1, j, grid, vis, dx, dy);
            }
        }
        
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0 && !vis[i][j]) {
                    dfs(i, j, grid, vis, dx, dy);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int row, int col, int[][] grid, boolean[][] vis, int[] dx, int[] dy) {
        vis[row][col] = true;
        
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (isValid(newRow, newCol, grid, vis)) {
                dfs(newRow, newCol, grid, vis, dx, dy);
            }
        }
    }
    
    private boolean isValid(int row, int col, int[][] grid, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        return row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 0 && !vis[row][col];
    }
}

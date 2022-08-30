// https://leetcode.com/problems/count-sub-islands/
// @author: anuj0503
class Solution {
    int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1},{0, -1}};
    boolean isIslandPossible;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int result = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid2[i][j] == 1){
                    isIslandPossible = true;
                    dfs(i, j, grid1, grid2, visited, m, n);
                    if(isIslandPossible){
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private void dfs(int x, int y, int[][] grid1, int[][] grid2, boolean[][] visited, int m, int n){
        if(grid1[x][y] != 1) {
                isIslandPossible = false;
        }
        
        visited[x][y] = true;

        for (int[] d : dir) {
            int newX = d[0] + x;
            int newY = d[1] + y;

            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid2[newX][newY] == 1 && !visited[newX][newY]) {
                dfs(newX, newY, grid1, grid2, visited, m, n);
            }
        }
    }
}

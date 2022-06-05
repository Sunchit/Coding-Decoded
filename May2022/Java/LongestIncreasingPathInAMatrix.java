
// @saorav21994
// TC : O(m*n)
// SC : O(m*n)


class Solution {
    
    int [][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        
        /* Do dfs from each cell (which is not previously visited) and store in dp[][] array and return max of them. */
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int [][] lip = new int[m][n];
        
        for (int [] row : lip) {
            Arrays.fill(row, -1);
        }
        
        int maxLip = 0;
        
        /* Do dfs for each cell */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLip = Math.max(maxLip, dfs(matrix, lip, i, j, Integer.MIN_VALUE /*lowest limit of cell as per question*/));
            }
        }
        
        return maxLip;
        
    }
    
    public int dfs(int [][] matrix, int [][] lip, int i, int j, int prev) {
        
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prev /*strictly increasing*/)
            return 0;
        
        if (lip[i][j] != -1)
            return lip[i][j];           // already explored
        
        int count = 1;
        
        for (int idx = 0; idx < 4; idx++) {
            count = Math.max(count, 1 + dfs(matrix, lip, i+dir[idx][0], j+dir[idx][1], matrix[i][j]/*current value*/));
        }
        
        lip[i][j] = count;
        
        return count;
        
    }
    
    
}

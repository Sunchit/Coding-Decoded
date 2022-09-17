
// @saorav21994
// TC : O(m*n)
// SC : O(m*n)

class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        /* in place only for square matrix ->
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        */
        
        // For non squared matrix, transpose(m * n) = (n * m)
        int [][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        
        return res;
    }
}

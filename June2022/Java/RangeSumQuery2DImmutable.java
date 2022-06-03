
// @saorav21994
// TC : O(m*n) for pre-computation
//      O(1) for each query
// SC : O(m*n) 
// Algo is explained for each part.

class NumMatrix {
    
    int [][] matrixt;

    public NumMatrix(int[][] matrix) {
        
      /* 
         Do pre-computation on matrix :
         A : For first column, do column top-down summation (column'd sum)
         B : For first row, do row left-right summation (row'd sum)
         For remaining (row,col), do ->
         C : matrix[r][c] = matrix[r][c-1] + (matrix[r-1][c] - matrix[r-1][c-1]) + matrix[r][c]
         In this way each matrix[r][c] will contain the sum from [0][0] to that [r][c] as a matrix
      */
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        matrixt = new int[m][n];
        matrixt[0][0] = matrix[0][0];
        
        // A : First row 
        for (int i = 1; i < n; i++) {
            matrixt[0][i] = matrix[0][i] + matrixt[0][i-1];
        }
        
        // B : First column
        for (int i = 1; i < m; i++) {
            matrixt[i][0] = matrix[i][0] + matrixt[i-1][0];
        }
        
        // C : formula for remaining [r][c]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrixt[i][j] = matrix[i][j] + matrixt[i][j-1] + (matrixt[i-1][j] - matrixt[i-1][j-1]);
            }
        }

        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        /*
            Formula for deriving the specific matrix sum ->
            sum = mat[r2][c2] - mat[r1-1][c2] - mat[r2][c1-1] + mat[r1-1][c1-1] (common area which got subtracted twice needs to be added back)
            incrementally checking boundary condition for each add/delete 
        */
        
        int sum = matrixt[row2][col2];
        if (row1-1 >= 0)
            sum -= matrixt[row1-1][col2];
        if (col1-1 >= 0)
            sum -= matrixt[row2][col1-1];
        if (row1-1 >= 0 && col1-1 >= 0)
            sum += matrixt[row1-1][col1-1];
        
        return sum;
        
        
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

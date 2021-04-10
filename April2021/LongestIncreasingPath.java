class Solution {
    // Tc : O(n*m)
    // SC : O(m*n)

    private int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};


    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null){
            return 0;
        }
        int m = matrix.length;
        if(m==0){
            return 0;
        }
        int n = matrix[0].length;
        if(n ==0){
            return 0;
        }
        int[][] cache = new int[m][n];

        int maxLength = 1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int currentMaxLength = dfs(i,j, matrix,m,n,cache);
                maxLength  =Math.max(maxLength, currentMaxLength);
            }
        }
        return maxLength;
    }

    private int dfs(int i, int j, int[][] matrix, int m, int n, int[][] cache){
        // if(i<0 || j<0 || i>=m || j>=n){
        //     return 0;
        // }
        if(cache[i][j]!=0){
            return cache[i][j];
        }

        int currentLen = 1;

        for(int[] direction : directions){
            int neighX = i + direction[0];
            int neighY = j + direction[1];
            if(neighX<0||neighY<0 || neighX >=m ||neighY>=n){
                continue;
            }
            if(matrix[i][j] >= matrix[neighX][neighY]){
                continue;
            }

            currentLen = Math.max(currentLen, 1+ dfs(neighX, neighY, matrix, m,n, cache));
        }
        cache[i][j] = currentLen;
        return   currentLen;
    }
}
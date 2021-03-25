class Solution {

    //TC  O(n2)
    // SC O(n2)
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> ans = new ArrayList<>();
        if(matrix == null || matrix.length ==0 || matrix[0].length ==0) {
            return ans;
        }
        int m =matrix.length;
        int n = matrix[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int j=0;j<n;j++){
            dfs(0,j, pacific, matrix, Integer.MIN_VALUE);

            dfs(m-1, j,atlantic,matrix, Integer.MIN_VALUE);
        }

        for(int i=0;i<m;i++){

            dfs(i,0, pacific, matrix, Integer.MIN_VALUE);

            dfs(i, n-1,atlantic,matrix, Integer.MIN_VALUE);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> indexes = new ArrayList<>();
                    indexes.add(i);
                    indexes.add(j);
                    ans.add(indexes);
                }
            }
        }
        return ans;

    }


    private void dfs(int i, int j, boolean[][] canReach, int[][] matrix, int prevHeight){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || canReach[i][j] || matrix[i][j] <prevHeight){
            return ;
        }

        canReach[i][j] = true;

        dfs(i+1, j, canReach, matrix, matrix[i][j]);
        dfs(i-1, j, canReach, matrix, matrix[i][j]);
        dfs(i, j-1, canReach, matrix, matrix[i][j]);
        dfs(i, j+1, canReach, matrix, matrix[i][j]);

    }

}
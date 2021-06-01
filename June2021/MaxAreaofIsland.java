class Solution {

    // TC : O(n*m)
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea, getCurrentArea(i,j, grid));
                }
            }
        }
        return maxArea;
    }



    private int getCurrentArea(int i,int j, int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]<=0){
            return 0;
        }
        // grid[i][j] = 1
        grid[i][j]=-1;
        int leftArea = getCurrentArea(i,j-1, grid);
        int rightArea = getCurrentArea(i,j+1, grid);
        int upArea = getCurrentArea(i-1,j, grid);
        int downArea = getCurrentArea(i+1,j, grid);

        int totalArea = 1 + leftArea + rightArea +upArea+downArea;

        return  totalArea;

    }
}
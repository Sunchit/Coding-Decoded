class Solution {
    //TC : O(m*n)
    //   SC : O(m*n)
    public int[] findDiagonalOrder(int[][] matrix) {
        int m= matrix.length;
        if(m==0){
            return new int[]{};
        }
        int n = matrix[0].length;
        if(n ==0 ){
            return new int[]{};
        }

        int[] ans = new int[m*n];
        int row =0;
        int col=0;
        for(int i=0;i<m*n;i++){
            ans[i] = matrix[row][col];
            if((row+col)%2==0){
                // even sum means upwards
                // row-- col++
                if(col == n-1){
                    row++;
                } else if(row ==0){
                    col++;
                } else{
                    row--;
                    col++;
                }
            } else{
                // odd sum means downwards

                if(row ==m-1){
                    col++;
                } else if(col==0){
                    row++;
                } else{
                    row++;
                    col--;
                }
            }
        }
        return ans;
    }
}
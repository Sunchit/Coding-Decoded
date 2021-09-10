//  @author Jagdish1998
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int row = n;
        int col = n;
        int[][] original = new int[row][col];
        for(int[] rowFill : original){
            Arrays.fill(rowFill, 1);
        }
        for(int[] subArr : mines){
            original[subArr[0]][subArr[1]] = 0;
        }
        int[][] forward = new int[row][col];
        int[][] backward = new int[row][col];
        int[][] downward = new int[row][col];
        int[][] upward = new int[row][col];
        for(int i=0; i<row; i++){
            int count = 1;
            for(int j=0; j<col; j++){
                if(original[i][j] == 1){
                    forward[i][j] = count;
                    count++;
                }else{
                    forward[i][j] = 0;
                    count = 1;
                }
            }
        }
        for(int i=0; i<row; i++){
            int count = 1;
            for(int j=col-1; j>=0; j--){
                if(original[i][j] == 1){
                    backward[i][j] = count;
                    count++;
                }else{
                    backward[i][j] = 0;
                    count = 1;
                }
            }
        }
        for(int j=0; j<col; j++){
            int count = 1;
            for(int i=0; i<row; i++){
                if(original[i][j] == 1){
                    downward[i][j] = count;
                    count++;
                }else{
                    downward[i][j] = 0;
                    count = 1;
                }
            }
        }
        for(int j=0; j<col; j++){
            int count = 1;
            for(int i=row-1; i>=0; i--){
                if(original[i][j] == 1){
                    upward[i][j] = count;
                    count++;
                }else{
                    upward[i][j] = 0;
                    count = 1;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int currVal = Math.min(forward[i][j], Math.min(backward[i][j], Math.min(downward[i][j], upward[i][j])));
                if(currVal > ans) ans = currVal;
            }
        }
        return ans;
    }
}

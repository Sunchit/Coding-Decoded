//  @author Santhosh
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {

        int[][] grid = new int[n][n];
        for (int[] row : grid) {
            Arrays.fill(row, 1);
        }

        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, n);
        }
        int curSum;

        for (int i = 0; i < n; i++) {
            curSum = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    curSum = 0;
                else
                    curSum++;
                dp[i][j] = Math.min(dp[i][j], curSum);
            }

            curSum = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0)
                    curSum = 0;
                else
                    curSum++;
                dp[i][j] = Math.min(dp[i][j], curSum);
            }
        }

        for (int j = 0; j < n; j++) {
            curSum = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 0)
                    curSum = 0;
                else
                    curSum++;
                dp[i][j] = Math.min(dp[i][j], curSum);
            }

            curSum = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] == 0)
                    curSum = 0;
                else
                    curSum++;
                dp[i][j] = Math.min(dp[i][j], curSum);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }
}

//@Sunchit
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {

        int[][] inputGrid = new int[n][n];
        for(int[] row: inputGrid){
            Arrays.fill(row, 1);
        }
        for(int[] mine : mines){

            inputGrid[mine[0]][mine[1]] =0;
        }

        int[][] lTR = new int[n][n];

        for(int i=0;i<n;i++){
            int runningSum = 0;
            for(int j=0;j<n;j++){

                if(inputGrid[i][j] == 0){
                    runningSum = 0;
                } else {
                    runningSum = inputGrid[i][j]+runningSum;
                }

                lTR[i][j]  = runningSum;
            }
        }



        int[][] rTL = new int[n][n];

        for(int i=0;i<n;i++){
            int runningSum = 0;
            for(int j=n-1;j>=0;j--){
                if(inputGrid[i][j] == 0){
                    runningSum = 0;
                } else {
                    runningSum = inputGrid[i][j]+runningSum;
                }
                rTL[i][j] = runningSum;
            }
        }

        int[][] tTB = new int[n][n];

        for(int i=0;i<n;i++){
            int runningSum = 0;
            for(int j=0;j<n;j++){
                if(inputGrid[j][i] == 0){
                    runningSum = 0;
                } else {
                    runningSum = inputGrid[j][i]+runningSum;
                }

                tTB[j][i]  = runningSum;
            }
        }



        int[][] bTT = new int[n][n];

        for(int i=0;i<n;i++){
            int runningSum = 0;
            for(int j=n-1;j>=0;j--){
                if(inputGrid[j][i] == 0){
                    runningSum = 0;
                } else {
                    runningSum = inputGrid[j][i]+runningSum;
                }

                bTT[j][i]  = runningSum;
            }
        }
        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int minLen = Math.min(Math.min(lTR[i][j], rTL[i][j]) , Math.min(bTT[i][j], tTB[i][j]));
                ans = Math.max(ans, minLen);
            }
        }
        return ans;
    }
}
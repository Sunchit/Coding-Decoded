
// @saorav21994
// TC : O (n^2)
// SC : O (n^2)

class Solution {
    public int[][] generateMatrix(int n) {
        int [][] ans = new int[n][n];
        int m = 1;
        int d = 0;
        int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0;
        while (m <= n * n) {
            ans[row][col] = m++;
            int r = Math.floorMod(row + dir[d][0], n);
            int c = Math.floorMod(col + dir[d][1], n);
            if (ans[r][c] != 0) 
                d = (d+1)%4;
            row += dir[d][0];
            col += dir[d][1];
            
        }
        return ans;
    }
}


// TC : O(n2)
// SC : O(n2)

public class Solution {
    public int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];

        if (n == 0) {
            return ans;
        }

        int startRow = 0;
        int endRow = n-1;
        int startColumn = 0;
        int endColumn = n - 1;

        int count = 1;

        while (startRow <= endRow && startColumn <= endColumn) {
            // Move towards right
            for (int j = startColumn; j <= endColumn; j ++) {

                ans[startRow][j] = count++;
            }
            startRow++;

            // Move towards down
            for (int i = startRow; i <= endRow; i ++) {
                ans[i][endColumn] = count++;
            }
            endColumn--;

            if (startRow <= endRow) {
                // Move towards left
                for (int j = endColumn; j >= startColumn; j --) {
                    ans[endRow][j] = count++;
                }
            }
            endRow--;

            if (startColumn <= endColumn) {
                // Move towards top
                for (int i = endRow; i >= startRow; i --) {
                    ans[i][startColumn] = count++;
                }
            }
            startColumn ++;
        }

        return ans;
    }

}

// Author: @romitdutta10
// TC : O (n^2)
// SC : O (n^2)
// Problem : https://leetcode.com/problems/spiral-matrix-ii/

class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0;
        int bottom = n;
        int right = n;
        int left = 0;

        int[][] arr = new int[n][n];

        int num = 1;
        while(top < bottom && left < right) {
            for(int j=left; j< right; j++) {
                arr[top][j] = num++;
            }



            top++;

            for(int i=top; i<bottom; i++) {
                arr[i][right-1] = num++;
            }

            right--;

            for(int j=right-1; j>=left; j--) {
                arr[bottom-1][j] = num++;
            }

            bottom--;

            for(int i=bottom-1; i>=top; i--) {
                arr[i][left] = num++;
            }

            left++;
        }

        return arr;
    }
}


// Author: @romitdutta10
// TC : O (n^2)
// SC : O (n^2)
// Problem : https://leetcode.com/problems/spiral-matrix-ii/

class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0;
        int bottom = n;
        int right = n;
        int left = 0;

        int[][] arr = new int[n][n];

        int num = 1;
        while(top < bottom && left < right) {
            for(int j=left; j< right; j++) {
                arr[top][j] = num++;
            }



            top++;

            for(int i=top; i<bottom; i++) {
                arr[i][right-1] = num++;
            }

            right--;

            for(int j=right-1; j>=left; j--) {
                arr[bottom-1][j] = num++;
            }

            bottom--;

            for(int i=bottom-1; i>=top; i--) {
                arr[i][left] = num++;
            }

            left++;
        }

        return arr;
    }
}

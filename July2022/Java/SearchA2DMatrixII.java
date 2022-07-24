
// @saorav21994
// TC : O(m+n)
// SC : O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0, j = n-1;
        
        while (i < m && j >= 0) {
            // System.out.println(matrix[i][j]);
            int val = matrix[i][j];
            if (val == target)
                return true;
            if (target < val)
                j -= 1;
            else
                i += 1;
        }
        
        return false;
        
    }
}


// @saorav21994
// TC : O(m+n)
// SC : O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = 0;
        if (m != 0) {
            n = matrix[0].length;
        }
        if (m == 0 || n == 0) return false;
        int i = 0, j = n-1;
        while (j >= 0 && i < m) {
            int cur = matrix[i][j];
            if (cur == target)
                return true;
            else if (cur < target) {
                i += 1;
            }
            else
                j -= 1;
        }
        return false;
    }
}

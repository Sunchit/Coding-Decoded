
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

// Author: @romitdutta10
// O(Row + logColumn)
// SC: O(1)
// Problem: https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i=0; i<n; i++) {
            if(matrix[i][0] <= target && matrix[i][m-1] >= target) {
                int low = 0;
                int high = m-1;
                
                while(low <= high) {
                    int mid = low + (high - low)/2;
                    
                    if(matrix[i][mid] == target) {
                        return true;
                    } else if(matrix[i][mid] > target) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            } else if(matrix[i][0] > target) {
                return false;
            }
        }
        
        return false;
    }
}

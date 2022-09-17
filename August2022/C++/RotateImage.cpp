// https://leetcode.com/problems/rotate-image/
class Solution {
public:
    // TC: O(n * n)
    // SC: O(1)
    void rotate(vector<vector<int>>& matrix) {
        // to rotate the matrix 90 degrees (clockwise)
        // step 1) get its transpose
        // step 2) reverse the columns
        
        int n = matrix.size();
        
        // transpose
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                swap(matrix[row][col], matrix[col][row]);
            }
        }
        
        // reverse the columns
        for (int row = 0; row < n; row++) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                swap(matrix[row][start], matrix[row][end]);
                start++;
                end--;
            }
        }
    }
};

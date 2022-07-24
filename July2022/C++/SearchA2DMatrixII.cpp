class Solution {
// TC: O(m + n)
// SC: O(1)
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();
        
        int row = 0;
        int col = n - 1;
        
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                // then all the elements in the current row will be less than target
                row++;
            } else {
                // then all the elements in the current col will be greater than target
                col--;
            }
        } 
        
        return false;
    }
};

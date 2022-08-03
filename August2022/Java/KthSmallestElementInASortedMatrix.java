
// @saorav21994
// TC : O(nlogn)
// SC : O(1)

class Solution {
    
    public int kthSmallest(int[][] matrix, int k) {
     
        // Using binary search technique
        // Find the mid, the number of values <= mid , if it is equal to k, then we return the value
        
        int n = matrix.length;
        
        // Because matrix is sorted row-wise and column-wies
        int low = matrix[0][0], high = matrix[n-1][n-1];
        
        while (low < high) {
            int mid = low + (high-low)/2;
            int count = lessThanEqualToMid(matrix, mid/*target*/);
            
            if (count < k) {
                low = mid+1;
            }            
            else {
                high = mid;
            }
        }
        
        return low;
        
    }
    
    
    public int lessThanEqualToMid(int [][] matrix, int target) {
        
        int column = 0, row = matrix.length-1;
        int n = matrix.length;
        
        int count = 0;
        
        while (column < n && row >= 0) {
            
            int curVal = matrix[row][column];
            
            if (curVal > target) {
                row -= 1;           // shift a row above
            }
            else {
                column += 1;
                
                // update the count to contain all elements (in the row) before this shift
                count += (row+1);   // row is 0-indexed
            }
        }
        
        return count;
        
    }
    
}

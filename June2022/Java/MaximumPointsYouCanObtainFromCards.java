
// @saorav21994
// TC : O(n)
// SC : O(1)

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        // compute minimum subarray sum with n-k elements and subtract that from totalSum.
        
        int n = cardPoints.length;
        int minItems = n - k;   // the number of items for which minimum subarray sum is to be calculated
        
        int curSum = 0;
        int totalSum = 0;
        
        for (int i = 0; i < minItems; i++) {
            curSum += cardPoints[i];
            totalSum += cardPoints[i];
        }
        
        int minSum = curSum;
        
        // window traversal
        for (int i = minItems; i < n; i++) {
            
            curSum = curSum - cardPoints[i-minItems] + cardPoints[i];
            minSum = Math.min(curSum, minSum);
            totalSum += cardPoints[i];
            
        }
        
        return totalSum - minSum;
        
    }
}

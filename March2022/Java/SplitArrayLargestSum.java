
// @saorav21994
// TC : O(n^2 * m)
// SC : O(m * n)

// Hint taken from official leetcode solution. Also this is not the most optimized solution.

class Solution {
    public int splitArray(int[] nums, int m) {
       
        int n = nums.length;
        int [] prefixSum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] += (nums[i-1] + prefixSum[i-1]);
        }
        
//         for (int i = 0; i <= n; i++)
//             System.out.println(prefixSum[i]);
        
        Integer [][] memo = new Integer[n+1][m+1];
        
        return getSplitSum(prefixSum, memo, 0, m, n);
    
    }
    
    public int getSplitSum(int [] prefixSum, Integer [][] memo, int curIndex, int remSubArrayCnt, int maxIdx) {
        
        if (memo[curIndex][remSubArrayCnt] != null) {
            return memo[curIndex][remSubArrayCnt];
        }
        
        if (remSubArrayCnt == 1) {
            return memo[curIndex][remSubArrayCnt] = (prefixSum[maxIdx] - prefixSum[curIndex]);
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = curIndex; i <= maxIdx - remSubArrayCnt; i++) {
            int curVal = prefixSum[i+1] - prefixSum[curIndex];
            int maxValue = Math.max(curVal, getSplitSum(prefixSum, memo, i+1, remSubArrayCnt-1, maxIdx));
            min = Math.min(min, maxValue);
            
            if (curVal >= min)  // all remaining will be larger 
                break;
        }
        
        return memo[curIndex][remSubArrayCnt] = min;
        
    }
    
    
}

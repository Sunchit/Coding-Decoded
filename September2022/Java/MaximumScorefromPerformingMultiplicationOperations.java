// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
// @author: anuj0503
// Bottom Up Approach
class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];

        // m denotes the multiplier index
        for(int i = m -1; i >= 0; i--){
            // left denotes the current left end index
            for(int left = 0; left <= i; left++){
                int right = left + n - i - 1; // Using left index we can get the right index
                
                if(i == m - 1){ // If we are calculating for last index of multiplier, it is either multiplication with left element or right element
                    dp[left][i] = Math.max(nums[left] * multipliers[i], nums[right] * multipliers[i]);
                } else { // Else it will be maximum of chossing either left or right with sum of already calculated step.
                    dp[left][i] = Math.max(nums[left] * multipliers[i] + dp[left + 1][i+1], nums[right] * multipliers[i] + dp[left][i+1]);
                }
            }
        }
        
        return dp[0][0];
    }
}

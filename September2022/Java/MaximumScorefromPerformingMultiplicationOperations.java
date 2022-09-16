
class Solution {

    private int n, m;
    private Integer[][] memo;


    public int maximumScore(int[] nums, int[] muls) {
        n = nums.length;
        m = muls.length;
        this.memo = new Integer[n][n];
        return dp(0, n-1, nums, muls, 0);
    }

    private int dp(int l, int r,int[] nums, int[] muls, int i) {
        if (i == m) return 0;

        if (memo[l][r] != null) return memo[l][r];

        int pickLeft = dp(l+1, r, nums, muls, i+1) + nums[l] * muls[i];
        int pickRight = dp(l, r-1, nums, muls, i+1) + nums[r] * muls[i];

        return memo[l][r] = Math.max(pickLeft, pickRight);
    }
}

class Solution {
    private int n, m;
    private Integer[][] memo;


    public int maximumScore(int[] nums, int[] muls) {
        n = nums.length;
        m = muls.length;

        this.memo = new Integer[m][m];
        return dp(0, 0, nums, muls);
    }
    private int dp(int l, int i,int[] nums, int[] muls) {
        if (i == m) return 0; // Picked enough m elements
        if (memo[l][i] != null) return memo[l][i];
        int pickLeft = dp(l+1, i+1, nums, muls) + nums[l] * muls[i];
        int pickRight = dp(l, i+1, nums, muls) + nums[n-(i-l)-1] * muls[i];
        return memo[l][i] = Math.max(pickLeft, pickRight);
    }
}



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

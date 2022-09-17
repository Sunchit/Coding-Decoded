// @saorav21994
// Tabulation - Accepted ✅
// TC : O(target*nums.length)
// SC : O(target)

// 0-1 knapsack like appproach 

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int [] res = new int[target+1];
        res[0] = 1;
        int l = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            int j = 0;
            while (j < l && nums[j] <= i) {
                res[i] += res[i-nums[j]];
                j += 1;
            }
        }
        return res[target];
    }
}


// Memoization - Accepted ✅
// TC: O(target * n)
// SC: O(target) + O(target) -> dp array + auxilary stack space
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        
        return helper(target, nums, dp);
    }
    
    private int helper(int T, int[] nums, int[] dp) {
        // base case
        if (T == 0) {
            return 1;
        }
        
        if (dp[T] != -1) {
            return dp[T];
        }
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= T) {
                count += helper(T - nums[i], nums, dp);
            }
        }
        
        return dp[T] = count;
    }
}


// Recursion - TLE ❌
// TC: O(target^n)
// SC: O(target)
class Solution {
    public int combinationSum4(int[] nums, int target) {
        return helper(target, nums);
    }
    
    private int helper(int T, int[] nums) {
        // base case
        if (T == 0) {
            return 1;
        }
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= T) {
                count += helper(T - nums[i], nums);
            }
        }
        
        return count;
    }
}

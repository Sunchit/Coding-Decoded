// Recursion - TLE ❌
// TC: O(target^n)
// SC: O(target)
class Solution {
private:
    int helper(int T, vector<int>& nums) {
        // base case
        if (T == 0) {
            return 1;
        }
        
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] <= T) {
                count += helper(T - nums[i], nums);
            }
        }
        
        return count;
    }
    
public:
    int combinationSum4(vector<int>& nums, int target) {
        return helper(target, nums);
    }
};


// Memoization - Accepted ✅
// TC: O(target * n)
// SC: O(target) + O(target)    -> dp array + auxilary stack space
class Solution {
private:
    int helper(int T, vector<int>& nums, vector<int>& dp) {
        // base case
        if (T == 0) {
            return 1;
        }
        
        if (dp[T] != -1) {
            return dp[T];
        }
        
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] <= T) {
                count += helper(T - nums[i], nums, dp);
            }
        }
        
        return dp[T] = count;
    }
    
public:
    int combinationSum4(vector<int>& nums, int target) {
        vector<int> dp(target + 1, -1);
        return helper(target, nums, dp);
    }
};


// Tabulation - Accepted ✅
// TC: O(target * n)
// SC: O(target)
class Solution {    
public:
    int combinationSum4(vector<int>& nums, int target) {
        vector<int> dp(target + 1, -1);
        
        // base case
        dp[0] = 1;
        
        int count = 0;
        for (int T = 1; T <= target; T++) {
            count = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (nums[i] <= T) {
                    count += dp[T - nums[i]];
                } else {
                    break;
                }
            }

            dp[T] = count;
        }
        
        return dp[target];
    }
};

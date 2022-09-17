// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

// Recursion - TLE ❌
class Solution {
private:
    int helper(int i, int l, vector<int>& multipliers, vector<int>& nums) {
        // base case
        if (i == multipliers.size()) {
            return 0;
        }    
        
        int e = nums.size() - (i - l) - 1;
        
        int pickLeft = (nums[l] * multipliers[i]) + helper(i + 1, l + 1, multipliers, nums);
        int pickRight = (nums[e] * multipliers[i]) + helper(i + 1, l, multipliers, nums);
        return max(pickLeft, pickRight);
    }
    
public:
	// TC: O(2 ^ m)
	// SC: O(m * m)
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        int n = nums.size();
        int m = multipliers.size();
        
        return helper(0, 0, multipliers, nums);
    }
};


// Dynamic Programming - Memoization ✔
class Solution {
private:
    int helper(int i, int l, vector<int>& multipliers, vector<int>& nums, vector<vector<int>>& dp) {
        // base case
        if (i == multipliers.size()) {
            return 0;
        }    
        if (dp[i][l] != INT_MIN) {
            return dp[i][l];
        }
        
        int e = nums.size() - (i - l) - 1;
        
        int pickLeft = (nums[l] * multipliers[i]) + helper(i + 1, l + 1, multipliers, nums, dp);
        int pickRight = (nums[e] * multipliers[i]) + helper(i + 1, l, multipliers, nums, dp);
        
        return dp[i][l] = max(pickLeft, pickRight);
    }
    
public:
    // TC: O(m * m)
    // SC: O(m * m) + O(m * m) -> auxilary stack space + dp array
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        int n = nums.size();
        int m = multipliers.size();
        
        vector<vector<int>> dp(m, vector<int>(m, INT_MIN));
        
        return helper(0, 0, multipliers, nums, dp);
    }
};


// Dynamic Programming - Tabulation ✔
class Solution {  
public:
    // TC: O(m * m)
    // SC: O(m * m) -> dp array
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        int n = nums.size();
        int m = multipliers.size();
        
        vector<vector<int>> dp(m + 1, vector<int>(m + 1, 0));
        
        for (int i = m - 1; i >= 0; i--) {
            for (int l = i; l >= 0; l--) {
                int e = nums.size() - (i - l) - 1;
        
                int pickLeft = (nums[l] * multipliers[i]) + dp[i + 1][l + 1];
                int pickRight = (nums[e] * multipliers[i]) + dp[i + 1][l];

                dp[i][l] = max(pickLeft, pickRight);
            }
        }
        
        return dp[0][0];
    }
};


// Dynamic Programming - Tabulation + Space Optimization ✔
class Solution {  
public:
    // TC: O(m * m)
    // SC: O(2 * m) -> dp array
    int maximumScore(vector<int>& nums, vector<int>& multipliers) {
        int n = nums.size();
        int m = multipliers.size();
        
        vector<int> front(m + 1, 0);
        
        for (int i = m - 1; i >= 0; i--) {
            vector<int> curr(m + 1, 0);
            for (int l = i; l >= 0; l--) {
                int e = nums.size() - (i - l) - 1;
        
                int pickLeft = (nums[l] * multipliers[i]) + front[l + 1];
                int pickRight = (nums[e] * multipliers[i]) + front[l];

                curr[l] = max(pickLeft, pickRight);
            }
            front = curr;
        }
        
        return front[0];
    }
};

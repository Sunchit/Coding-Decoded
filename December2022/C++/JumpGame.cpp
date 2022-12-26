// https://leetcode.com/problems/jump-game/

// Memoization
class Solution {
private:
    bool helper(int ind, vector<int>& nums, vector<int>& dp) {
        // base case
        if (ind == nums.size() - 1) {
            return true;
        }
        
        if (dp[ind] != -1) {
            return dp[ind];
        }
        
        for (int jumps = 1; jumps <= nums[ind]; jumps++) {
            if (ind + jumps < nums.size()) {
                if (helper(ind + jumps, nums, dp)) {
                    return dp[ind] = true;
                }
            }
        }
        return dp[ind] = false;
    }
    
public:
    // TC: O(n)
    // SC: O(n) + O(n)
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n, -1);
        return helper(0, nums, dp);
    }
};


// Tabulation 
class Solution {
public:
    // TC: O(n)
    // SC: O(n)
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n, -1);
        
        // base case
        dp[n - 1] = true;
        
        for (int ind = n - 2; ind >= 0; ind--) {
            bool flag = false;
            for (int jumps = 1; jumps <= nums[ind]; jumps++) {
                if (ind + jumps < n) {                    
                    if (dp[ind + jumps] == 1) {
                        flag = true;
                        break;
                    }
                }
            }
            dp[ind] = flag;
        }
        
        return dp[0];
    }
};

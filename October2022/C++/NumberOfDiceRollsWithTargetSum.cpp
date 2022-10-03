// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

// Memoization - ✅
// TC: O(n * target)
// SC: O(n * target) + O(n)	-> dp array + auxiliary stack space
class Solution {
private:
    int MOD = (int) 1e9 + 7;
    
    long helper(int dice, int k, int target, vector<vector<long>>& dp) {
        // base case
        if (target < 0) {
            return 0;
        }
        if (dice == 0 && target != 0) {
            return 0;
        }
        if (dice == 0 && target == 0) {
            return 1;
        }
        
        if (dp[dice][target] != -1) {
            return dp[dice][target];
        }
        
        long count = 0;
        for (int i = 1; i <= k; i++) {
            if (i <= target) {
                count += helper(dice - 1, k, target - i, dp) % MOD;   
            }
        }
        
        return dp[dice][target] = count % MOD;
    }
    
public:
    int numRollsToTarget(int n, int k, int target) {
        vector<vector<long>> dp(n + 1, vector<long>(target + 1, -1));
        return helper(n, k, target, dp);
    }
};


// Tabulation - ✅
// TC: O(n * target)
// SC: O(n * target)  -> dp array
class Solution {
private:
    int MOD = (int) 1e9 + 7;
    
public:
    int numRollsToTarget(int n, int k, int target) {
        vector<vector<long>> dp(n + 1, vector<long>(target + 1, 0));
        
        // base case
        dp[0][0] = 1;
        
        for (int dice = 1; dice <= n; dice++) {
            for (int T = 1; T <= target; T++) {
                long count = 0;
                for (int i = 1; i <= k; i++) {
                    if (i <= T) {
                        count += dp[dice - 1][T - i] % MOD;   
                    }
                }
                dp[dice][T] = count % MOD;
            }
        }
        
        return dp[n][target];
    }
};

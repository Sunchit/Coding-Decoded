class Solution {
public: 
    // DP - Tabulation + Space Optimization
    // TC: O(n)
    // SC: O(1)
    int fib(int n) {
        // base case
        int prev2 = 0;
        if (n == 0) {
            return prev2;
        }
        int prev = 1;
        if (n == 1) {
            return prev;
        }
        
        for (int ind = 2; ind <= n; ind++) {
            int curr = prev + prev2;
            
            prev2 = prev;
            prev = curr;
        }
        
        return prev;
    }



    // DP - Tabulation
    // TC: O(n)
    // SC: O(n) -> dp array
    /* int fib(int n) {
        vector<int> dp(n + 1, 0);
        
        if (n == 0 || n == 1) {
            return n;
        }
        
        // base case
        dp[0] = 0;
        dp[1] = 1;
        
        for (int ind = 2; ind <= n; ind++) {
            dp[ind] = dp[ind - 1] + dp[ind - 2];
        }
        
        return dp[n];
    } */



    // DP - Memoization
    // TC: O(n)
    // SC: O(n) + O(n) -> dp array + auxiliary stack
    /* int fib(int n) {
        vector<int> dp(n + 1, -1);        
        return helper(n, dp);
    }
    
    int helper(int ind, vector<int> dp) {
        // base case
        if (ind == 0 || ind == 1) {
            return ind;
        }
        
        if (dp[ind] != -1) {
            return dp[ind];
        }
        
        return dp[ind] = helper(ind - 1, dp) + helper(ind - 2, dp);
    } */



    // Recursion
    // TC: O(2^n)
    // SC: O(n) -> auxiliary stack
    /* int fib(int n) {
        return helper(n);
    }
    
    int helper(int ind) {
        if (ind == 0 || ind == 1) {
            return ind;
        }
        return helper(ind - 1) + helper(ind - 2);
    } */
};

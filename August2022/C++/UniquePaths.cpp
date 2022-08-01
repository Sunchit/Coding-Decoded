// Recursive - TLE ❌
// TC: O(2^n)
// SC: O(m + n)
class Solution {
private:
    int helper(int i, int j) {
        if (i == 0 && j == 0) { // we have reached to the starting point
            return 1;
        }
        if (i < 0 || j < 0) {   // if we go outside the grid
            return 0;
        }
        
        int up = helper(i - 1, j);
        int left = helper(i, j - 1);
        
        return up + left;
    }
    
public:
    int uniquePaths(int m, int n) {
        return helper(m - 1, n - 1);
    }
};


// Memoization - Accepted ✅
// TC: O(m * n)
// SC: O(m * n) + O(m * n)  -> dp array + auxilary stack space
class Solution {
private:
    int helper(int i, int j, vector<vector<int>> dp) {
        if (i == 0 && j == 0) { // we have reached to the starting point
            return 1;
        }
        if (i < 0 || j < 0) {   // if we go outside the grid
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int up = helper(i - 1, j, dp);
        int left = helper(i, j - 1, dp);
        
        return dp[i][j] = up + left;
    }
    
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(m, vector<int>(n, -1));
        return helper(m - 1, n - 1, dp);
    }
};


// Tabulation - Accepted ✅
// TC: O(m * n)
// SC: O(m * n) -> dp array
class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(m, vector<int>(n, 0));
        
        // base case
        dp[0][0] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                
                int up = 0;
                int left = 0;
                
                if (i - 1 >= 0) {
                    up = dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    left = dp[i][j - 1];
                }
        
                dp[i][j] = up + left;
            }
        }
        
        return dp[m - 1][n - 1];        
    }
};


// Tabulation + Space Optimization - Accepted ✅
// TC: O(m * n)
// SC: O(2 * n)
class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(2, vector<int>(n, 0));
        
        // base case
        dp[0][0] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                
                int up = 0;
                int left = 0;
                
                if (i - 1 >= 0) {
                    up = dp[(i - 1) % 2][j];
                }
                if (j - 1 >= 0) {
                    left = dp[i % 2][j - 1];
                }
        
                dp[i % 2][j] = up + left;
            }
        }
        
        return dp[(m - 1) % 2][n - 1];        
    }
};

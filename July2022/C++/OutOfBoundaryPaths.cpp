// Recursion - TLE ❌
// TC: O(n^4)
// SC: O(m * n * moves)
class Solution {
private:
    int MOD = (int) (1e9 + 7);

    int helper(int i, int j, int moves, int m, int n) {
        // base case
        if (i < 0 || i == m || j < 0 || j == n) {
            return 1;
        }
        if (moves == 0) {
            return 0;
        }
        
        int top = helper(i - 1, j, moves - 1, m, n) % MOD;
        int down = helper(i + 1, j, moves - 1, m, n) % MOD;
        int left = helper(i, j - 1, moves - 1, m, n) % MOD;
        int right = helper(i, j + 1, moves - 1, m, n) % MOD;
        
        return (top + down) % MOD + (left + right) % MOD;
    }
    
public:    
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return helper(startRow, startColumn, maxMove, m, n) % MOD;
    }
};



// Memoization - Accepted ✅
// TC: O(m * n * maxMove)
// SC: O(m * n * maxMove)   -> 3d dp array
class Solution {
private:
    int MOD = (int) (1e9 + 7);

    int helper(int i, int j, int moves, int m, int n, vector<vector<vector<int>>>& dp) {
        // base case
        if (i < 0 || i == m || j < 0 || j == n) {
            return 1;
        }
        if (moves == 0) {
            return 0;
        }

        if (dp[i][j][moves] != -1) {
            return dp[i][j][moves];
        }

        int top = helper(i - 1, j, moves - 1, m, n, dp) % MOD;
        int down = helper(i + 1, j, moves - 1, m, n, dp) % MOD;
        int left = helper(i, j - 1, moves - 1, m, n, dp) % MOD;
        int right = helper(i, j + 1, moves - 1, m, n, dp) % MOD;

        return dp[i][j][moves] = (top + down) % MOD + (left + right) % MOD;
    }
    
public:
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(maxMove + 1, -1)));        
        return helper(startRow, startColumn, maxMove, m, n, dp) % MOD;        
    }
};

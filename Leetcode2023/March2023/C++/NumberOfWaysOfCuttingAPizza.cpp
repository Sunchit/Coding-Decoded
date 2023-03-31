// https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/
class Solution {
private:
    const int MOD = 1e9 + 7;

    int helper(int r, int c, int k, int rows, int cols, vector<vector<int>>& prefixSum, vector<vector<vector<int>>>& dp) {
        // Base case
        if (prefixSum[r][c] == 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }

        if (dp[r][c][k] != -1) {
            return dp[r][c][k];
        }

        int count = 0;
        for (int newRow = r + 1; newRow < rows; newRow++) {
            if (prefixSum[r][c] - prefixSum[newRow][c] > 0) {
                count += helper(newRow, c, k - 1, rows, cols, prefixSum, dp);
                count %= MOD;
            }
        }

        for (int newCol = c + 1; newCol < cols; newCol++) {
        if (prefixSum[r][c] - prefixSum[r][newCol] > 0) {
                count += helper(r, newCol, k - 1, rows, cols, prefixSum, dp);
                count %= MOD;
            }
        }

        return dp[r][c][k] = count % MOD;
    }

public:
    int ways(vector<string>& pizza, int k) {
        int rows = pizza.size();
        int cols = pizza[0].size();

        // Generate prefix sum
        vector<vector<int>> prefixSum(rows + 1, vector<int>(cols + 1));
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                prefixSum[i][j] += (pizza[i][j] == 'A' ? 1 : 0);
                if (i + 1 < rows) {
                    prefixSum[i][j] += prefixSum[i + 1][j];
                }
                if (j + 1 < cols) {
                    prefixSum[i][j] += prefixSum[i][j + 1];
                }
                if (i + 1 < rows && j + 1 < cols) {
                    prefixSum[i][j] -= prefixSum[i + 1][j + 1];
                }
            }
        }

        vector<vector<vector<int>>> dp(rows, vector<vector<int>>(cols, vector<int>(k, -1)));
        
        return helper(0, 0, k - 1, rows, cols, prefixSum, dp) % MOD;
    }
};

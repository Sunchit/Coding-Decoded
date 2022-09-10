// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
class Solution {
public:
    // TC: O(n * k)
    // SC: O(n * k)
    int maxProfit(int k, vector<int>& prices) {
        int n = prices.size();
        
        if (n <= 1 || k == 0) {
            return 0;
        }

        vector<vector<int>> dp(k + 1, vector<int>(n, 0));

        for (int trans = 1; trans <= k; trans++) {
            int maxProfitWithTM1transaction = INT_MIN;
            for (int day = 1; day < n; day++) {
                maxProfitWithTM1transaction = max(maxProfitWithTM1transaction, dp[trans - 1][day - 1] - prices[day - 1]);
                int profitWith1LTrans = maxProfitWithTM1transaction + prices[day];
                dp[trans][day] = max(dp[trans][day - 1], profitWith1LTrans);
            }
        }

        return dp[k][n - 1];        
    }
};

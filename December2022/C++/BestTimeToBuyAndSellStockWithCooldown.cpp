// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

// Memoization
// TC: O(n * 2)
// SC: O(n * 2) + O(n)
class Solution {
private:
    int helper(int day, bool buy, vector<int>& prices, vector<vector<int>>& dp) {
        // base case
        if (day >= prices.size()) {
            return 0;
        }
        if (dp[day][buy] != -1) {
            return dp[day][buy];
        }
        
        int profit = 0;
        if (buy) {  // buy
            int take = helper(day + 1, false, prices, dp) - prices[day];
            int notTake = helper(day + 1, true, prices, dp);
            profit = max(take, notTake);
        } else {    // sell
            int sell = prices[day] + helper(day + 2, true, prices, dp);
            int notSell = helper(day + 1, false, prices, dp);
            profit = max(sell, notSell);
        }
        return dp[day][buy] = profit;
    }

public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n + 2, vector<int>(2, -1));
        return helper(0, true, prices, dp);
    }
};


// Tabulation
// TC: O(n * 2)
// SC: O(n * 2)
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n + 2, vector<int>(2, 0));
        
        for (int day = n - 1; day >= 0; day--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {  // buy
                    int take = dp[day + 1][0] - prices[day];
                    int notTake = dp[day + 1][1];
                    profit = max(take, notTake);
                } else {    // sell
                    int sell = prices[day] + dp[day + 2][1];
                    int notSell = dp[day + 1][0];
                    profit = max(sell, notSell);
                }
                dp[day][buy] = profit;
            }    
        }
        
        return dp[0][1];        
    }
};

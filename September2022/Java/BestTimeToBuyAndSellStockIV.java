
// @saorav21994
// TC : O(n*k)
// SC : O(n*k)

class Solution {
    public int maxProfit(int k, int[] prices) {
        
        // Need to have dp [transactions][days]
        // Each cell signifies max profit with t transactions till d days
        // Competing values for each cell -> Max of (t days made till d-1 days = dp[t][d-1], max of all [prev days value with t-1 transaction+price of current day-prev dth day price])
                
        int l = prices.length;
        
        if (l <= 1 || k == 0)
            return 0;
        
        int [][] dp = new int[k+1][l];
        
        // First row = first column = 0, bcoz 0th day no profit, 0 transaction no profit
        
        for (int trans = 1; trans <= k; trans++) {
            
            int maxProfitWithTM1transaction = Integer.MIN_VALUE;
            
            for (int day = 1; day < l; day++) {
                
                maxProfitWithTM1transaction = Math.max(maxProfitWithTM1transaction, dp[trans-1][day-1] - prices[day-1]);
                int profitWith1LTrans = maxProfitWithTM1transaction + prices[day];
                dp[trans][day] = Math.max(dp[trans][day-1], profitWith1LTrans);
            }
            
        }
        
        return dp[k][l-1];
        
    }
}

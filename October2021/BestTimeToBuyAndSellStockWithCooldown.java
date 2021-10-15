class Solution {
    // TC : O(n)
    // SC : O(n)
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0; // 1 0

        int[] profit = new int[len];

        int[] buy  = new int[len];

        buy[0]  = 0 -prices[0];
        buy[1]  = 0 - Math.min(prices[0], prices[1]);

        // Buying thing will be in negative
        profit[1] = Math.max(0, buy[0] + prices[1]);

        for (int i = 2; i < len; i++){
            buy[i]  = Math.max(buy[i - 1], profit[i - 2] - prices[i]);
            profit[i] = Math.max(profit[i - 1], buy[i - 1] + prices[i]);
            // Profit =S.P -CP
        }

        return profit[len - 1];
    }
}
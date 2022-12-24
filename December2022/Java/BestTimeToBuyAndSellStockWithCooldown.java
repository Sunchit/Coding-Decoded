// @saorav21994

class Solution {
    public int maxProfit(int[] prices) {
        int l = prices.length;
        if (l < 2) return 0;
        int [] buy = new int[l];
        int [] sell = new int[l];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i = 0; i < l; i++) {
            buy[i] = Math.max(((i > 0) ? buy[i-1] : -prices[0]), ((i > 1) ? sell[i-2] : 0) - prices[i]);
            sell[i] = Math.max(((i > 0) ? buy[i-1] : -prices[0]) + prices[i], ((i > 0) ? sell[i-1] : 0));
        }
        return sell[l-1];
    }
}

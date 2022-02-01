// TC : O(n)
// SC :O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int sellingPrice = 0;
        for(int i=prices.length-1;i>=0;i--){
            sellingPrice  = Math.max(sellingPrice, prices[i]);

            maxProfit = Math.max(maxProfit,sellingPrice - prices[i]);
        }
        return maxProfit;
    }
}
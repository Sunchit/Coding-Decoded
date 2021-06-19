class BestTimeToBuyAndSellStockIII.java {
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int len = prices.length;
        int[] leftProfit = new int[len];
        int leftMin = prices[0]; // buying prices
        for(int i=1;i<len;i++){
            leftMin = Math.min(leftMin, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i-1], prices[i] - leftMin);
        }

        int[] rightProfit = new int[len];
        // selling prices
        int rightMax = prices[len-1];
        for(int i=len-2;i>=0;i--){
            rightMax = Math.max(rightMax, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i+1], rightMax - prices[i]);
        }
        int maxProfit = 0;
        for(int i=0;i<len;i++){
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }
        return maxProfit;
    }
}
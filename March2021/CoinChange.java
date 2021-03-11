class Solution {
    // TC : O(amount * Coin count)
    // SC : O(amount)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int el: coins){
                if( i - el >=0 &&  dp[i-el] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-el] +1);
                }
            }
        }

        if(dp[amount] == Integer.MAX_VALUE){
            return -1;
        } else {
            return dp[amount];
        }
    }
}
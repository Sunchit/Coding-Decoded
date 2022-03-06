// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int countOrders(int n) {
        long[] dp=new long[n+1];
        dp[1]=1;
        long mod=1000000007;
        for(int i=2;i<n+1;i++){
            dp[i]=((((2*i)-1)*(2*i))/2)*(dp[i-1])%mod;
        }
        return (int)dp[n];
    }
}

// @saorav21994
// For arranging all pickup we will have n! options as relative arrangement among them does not matter
// For arranging all delivery we will have 1*3*5*3...*(2n-1) options as D[i] can come at any place but only after P[i]
// TC : O(n)
// SC : O(1)

// In C++, bottom up approach solution is given


class Solution {
    
    public int countOrders(int n) {
        
        long res = 1l;
        final int MOD = 1000000007;
        
        for (int i = 1; i <= n; i++) {
            res *= i;           // n! for pickup arrangement
            res %= MOD;
            res *= (2*i-1);     // 1*3*5*...(2n-1) for delivery
            res %= MOD;
        }
        return (int)res;
    }
}


class Solution {
    // Tc : O(n)
    // Sc : O(n)
    public int countOrders(int n) {
        long[] dp = new long[501];
        int mod = (int) Math.pow(10,9) + 7;
        dp[1]=1L;
        dp[2]=6L;
        for (int i=3;i<=n;i++) {
            int odddNo = 2 * i -1;
            int permutations = odddNo * (odddNo+1)/2;
            dp[i] = (dp[i-1]*(permutations))%mod;
        }
        return (int) dp[n];
    }

}
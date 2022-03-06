
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

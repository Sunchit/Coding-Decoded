
// @saorav21994
// TC : O(n^2)
// SC : O(n^2)

// Bottom up approach, DP -> recurrence relation => dp[i][j] = (unpicked order) * countOrder(unpicked-1, undelivered) + (orderPicked but undelivered) * countOrder(unpicked, undelivered-1)


class Solution {
public:
    int countOrders(int n) {
        int MOD = 1000000007;
        
        int i = 0;  // unpicked items
        int j = 0;  // undelivered items
        
        long dp[n+1][n+1];
    
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 0;
            }
        }
        
        for (i = 0; i <= n; i++) {
            for (j = i; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                
                if (i > 0) {
                    dp[i][j] += i * dp[i-1][j];
                }
                dp[i][j] %= MOD;
                
                if (j > i) {
                    dp[i][j] += (j-i) * dp[i][j-1];
                }
                dp[i][j] %= MOD;
                
            }
        }
        return (int)dp[n][n]; 
    }
};

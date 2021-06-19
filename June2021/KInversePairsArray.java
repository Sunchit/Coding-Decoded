//public class Solution {
//     Integer[][] memo = new Integer[1001][1001];
//     public int kInversePairs(int n, int k) {
//         if (n == 0)
//             return 0;
//         if (k == 0)
//             return 1;
//         if (memo[n][k] != null)
//             return memo[n][k];
//         int inv = 0;
//         for (int i = 0; i <= Math.min(k, n - 1); i++) {
//             inv = (inv + kInversePairs(n - 1, k - i)) % 1000000007;
//         }
//         memo[n][k] = inv;
//         return inv;
//     }
// }


public class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        // building answer for all values of N starting 1 going upto N
        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    // since J is 0,  sorted case would make it count to 1q
                    dp[i][j] = 1;
                }
                else {
                    for (int p = 0; p <= Math.min(j, i - 1); p++)
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - p]) % 1000000007;
                }
            }
        }
        return dp[n][k];
    }
}
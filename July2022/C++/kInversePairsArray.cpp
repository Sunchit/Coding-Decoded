class Solution {
public:
    int kInversePairs(int n, int k) {
        
        int dp[1001][1001] = {1};
        int mod = 1e9+7;
        for(int N=1;N<=n;N++)
        {
            for(int K=0;K<=k;K++)
            {
                for(int i=0;i<=min(N-1,K);i++)
                    
                    dp[N][K] = (dp[N][K] +dp[N-1][K-i])%mod;
            }
        }
        return dp[n][k];
    }
};

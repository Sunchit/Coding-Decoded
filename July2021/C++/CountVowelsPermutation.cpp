class Solution {
public:
    const int m=1e9+7;
    int countVowelPermutation(int n) {
        long long dp[5][n+1];
        long long ans=0;
        dp[0][1]=dp[1][1]=dp[2][1]=dp[3][1]=dp[4][1]=1;
        for(long long j=2; j<=n; j++)
        {
            dp[0][j]=dp[1][j-1];
            dp[1][j]=(dp[0][j-1]+dp[2][j-1])%m;
            dp[2][j]=(dp[0][j-1]+dp[1][j-1]+dp[3][j-1]+dp[4][j-1])%m;
            dp[3][j]=(dp[2][j-1]+dp[4][j-1])%m;
            dp[4][j]=dp[0][j-1];
        }
        for(long long j=0; j<5; j++)
        {
            ans=(ans+dp[j][n])%m;
        }
        return ans;
    }
};
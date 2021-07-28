class Solution
{
public:
    bool betweenJZ(char l, char r)
    {
        if (l == '1' && r >= '0' && r <= '9')
            return true;
        if (l == '2' && r >= '0' && r <= '6')
            return true;
        return false;
    }

    int numDecodings(string s)
    {

        if (s[0] == '0')
            return 0;
        int MOD = 1e9 + 7;
        vector<long long> dp(s.length() + 1, 0);
        dp[1] = dp[0] = 1;
        if (s[0] == '*')
            dp[1] = 9;
        for (int i = 2; i < dp.size(); ++i)
        {
            if (s[i - 1] == '0')
            {
                if (s[i - 2] >= '3' || s[i - 2] == '0')
                    return 0;
                dp[i] = dp[i - 2] % MOD;
                if (s[i - 2] == '*')
                    dp[i] = (dp[i] * 2) % MOD;
            }
            else if (betweenJZ(s[i - 2], s[i - 1]))
            {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }
            else if (s[i - 1] == '*')
            {
                dp[i] = (dp[i - 1] * 9) % MOD;
                if (s[i - 2] == '1' || s[i - 2] == '*')
                    dp[i] += (dp[i - 2] * 9) % MOD;
                if (s[i - 2] == '2' || s[i - 2] == '*')
                    dp[i] += (dp[i - 2] * 6) % MOD;
            }
            else
            {
                dp[i] = dp[i - 1] % MOD;
                if (s[i - 2] == '*')
                {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
                    if (s[i - 1] <= '6')
                        dp[i] = (dp[i] + dp[i - 2]) % MOD;
                }
            }
        }
        return dp[dp.size() - 1] % MOD;
    }
};
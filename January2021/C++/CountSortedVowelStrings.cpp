/**
 * 
 * @author ssrbazpur
 * Time Complexity: O(N) sc:o(1)
* */

class Solution
{
public:
    int countVowelStrings(int n)
    {

        vector<int> dp(5, 1);

        for (int i = 2; i <= n; i++)
        {

            for (int j = 3; j >= 0; j--)
            {
                dp[j] = dp[j] + dp[j + 1];
            }
        }

        int ans = 0;
        for (int a : dp)
        {
            ans += a;
        }

        return ans;
    }
};
class Solution {
public:
    double champagneTower(int poured, int query_row, int query_glass) {
        vector<vector<double>> dp(101,vector<double>(101,0));
        dp[0][0]=poured;
        double rest=0;
        for(int i=0;i<query_row;i++)
        {
            for(int j=0;j<101;j++)
            {
                if(dp[i][j]>1)
                {
                    rest=dp[i][j]-1;
                    dp[i+1][j]+=rest/2.0;
                    dp[i+1][j+1]+=rest/2.0;
                }
            }
        }
        return dp[query_row][query_glass]>1?1:dp[query_row][query_glass];
    }
};
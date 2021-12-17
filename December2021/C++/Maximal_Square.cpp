class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m=matrix.size(),n=matrix[0].size();
        vector<vector<int>> dp(m+1,vector<int>(n+1,0));
        int res=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]=='1')
                {
                    // cout<<i<<" "<<j<<endl;
                    dp[i+1][j+1]=1+min({dp[i][j],dp[i][j+1],dp[i+1][j]});
                    // cout<<"dp val : "<<dp[i+1][j+1]<<endl;
                    res=max((int)res,(int)dp[i+1][j+1]);
                }
            }
        }
        return res*res;
    }
};
class Solution {
public:
    int countVowelStrings(int n) {
        vector<vector<int>> dp(5,vector<int>(n+1,0));
        for(int i=0;i<5;i++) dp[i][1]=1;
        int sum=5,temp=5;
        for(int i=2;i<=n;i++)
        {
            sum=temp;
            temp=0;
            for(int j=0;j<5;j++)
            {
                if(j==0) dp[j][i]=sum;
                else
                {
                    sum-=dp[j-1][i-1];
                    dp[j][i]=sum;
                }
                temp+=dp[j][i];
            }
        }
        sum=temp;
        
        
        return sum;
        
        
    }
};
class Solution {
    private:
    bool f(int i,int j,int l,vector<vector<int>> &dp,string 
           &s1,string &s2,string &s3)
    {
        if(i==s1.length() and j==s2.length() and l==s3.length()) return 1;
        if(i>s1.length() or j>s2.length()) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        // If both strings char equals to s3
        if(s1[i]==s3[l] and s2[j]==s3[l])
            return dp[i][j] = (f(i+1,j,l+1,dp,s1,s2,s3) or
                              f(i,j+1,l+1,dp,s1,s2,s3));
        
        // If s1 char equals to s3
        else if(s1[i]==s3[l]) return dp[i][j] = f(i+1,j,l+1,dp,s1,s2,s3);
    
        // If s2 char equals to s3
        else if(s2[j]==s3[l]) return dp[i][j] = f(i,j+1,l+1,dp,s1,s2,s3);
        
        return dp[i][j] = 0;
    }
public:
    bool isInterleave(string s1, string s2, string s3) {
        
        int n = s1.length(), m = s2.length(), l = s3.length();
        
        if(n+m != l) return 0;
        vector<vector<int>> dp(n+1,vector<int> (m+1,-1));
        return f(0,0,0,dp,s1,s2,s3);
    }
};

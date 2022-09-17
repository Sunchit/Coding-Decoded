class Solution {
//     TC - O(M*N*maxMove)
//     SC - O(M*N*maxMove)
    private:
    int dp[55][55][55];
    int mod = 1e9+7; 
    int f(int i,int j,int m,int n,int maxmove)
    {
        if(i>=m or i<0)
        {
            if(maxmove>=0) return 1;
            else return 0;
        }
        if(j>=n or j<0)
        {
            if(maxmove>=0) return 1;
            else return 0; 
        }
        if(maxmove<0) return 0;
        
        if(dp[i][j][maxmove] != -1) return dp[i][j][maxmove];
        
        int l = f(i,j-1,m,n,maxmove-1);        
        int r = f(i,j+1,m,n,maxmove-1);
        int u = f(i-1,j,m,n,maxmove-1);
        int d = f(i+1,j,m,n,maxmove-1);
        
        return dp[i][j][maxmove] = ((l+r)%mod + (u+d)%mod)%mod;
    }
    public:
    int findPaths(int m, int n, int maxMove, int stRow, int stCol) {
        
        memset(dp,-1,sizeof(dp));
        return f(stRow,stCol,m,n,maxMove);
    }
};

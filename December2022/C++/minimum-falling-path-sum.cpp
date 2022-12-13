class Solution {
private:
    int findMinPathSum(vector<vector<int>>& matrix, int n ,int m, int i,int j,vector<vector<int>>&dp){
        
        if(i<0 || i>=n || j<0 || j>=m){
            return 1e9;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(i==(n-1)){
            return matrix[i][j];
        }
        int val1 = matrix[i][j] + findMinPathSum(matrix, n,m,i+1,j,dp);
        int val2 = matrix[i][j] +  findMinPathSum(matrix, n,m,i+1,j-1,dp);
        int val3 = matrix[i][j] +  findMinPathSum(matrix, n,m,i+1,j+1,dp);
        
        
        return dp[i][j] = min({val1,val2,val3});
    }
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        
        // dp[i][j] -> Minimum path sum that we can get starting from i, j
        
        int n = matrix.size();
        int m = matrix[0].size();
        
        vector<vector<int>>dp(n,vector<int>(m,-1));
        
        int ans = INT_MAX;
        
        for(int i=0;i<m;i++){
           int val = findMinPathSum(matrix, n, m, 0, i,dp);
              ans = min(ans, val);
            
        }
        
        return ans;
    }
};
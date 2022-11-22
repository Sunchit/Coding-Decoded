class Solution {
private:
    int isPerfect(int num){
        int val = sqrt(num);
        
        return val*val == num;
    }
public:
    int numSquares(int n) {
      vector<int>dp(n+1,1e9);
        
        dp[0] = 0;
        
        int count = 1;
        
        while(count*count<=n){
            int num = count*count;
            
            for(int j=num;j<=n;j++){
                dp[j] = min(dp[j-num]+1,dp[j]);
            }
            count++;
        }
        
        return dp[n];
    }
};
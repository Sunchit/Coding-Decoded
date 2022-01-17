class Solution {
public:
    long long mostPoints(vector<vector<int>>& arr) {
        long long n = arr.size();
        vector<long long> dp(n,0);
        for(long i = n-1;i>=0;i--){
                dp[i]=arr[i][0];
            if((arr[i][1]+i+1)<n)
                dp[i]=max(dp[i],dp[arr[i][1]+i+1]+(arr[i][0]));
            if(i+1<n)
                dp[i]=max(dp[i],dp[i+1]);
        }
        return dp[0];
    }
};

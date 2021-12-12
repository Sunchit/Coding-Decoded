class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int arrsum=0;
        for(auto& i:nums) arrsum+=i;
        
        if(arrsum%2) return false;
        vector<vector<int>> dp(nums.size()+1,vector<int>((arrsum/2)+1,false));
        for(int i=0;i<=nums.size();i++) dp[i][0]=true;
        
        for(int i=1;i<=nums.size();i++)
        {
            // cout<<i<<endl;
            for(int j=1;j<=(arrsum/2);j++)
            {
                if(nums[i-1]<=j)
                    dp[i][j]=dp[i-1][j-nums[i-1]]||dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[nums.size()][arrsum/2];
    }

};
class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size()<2) 
            return nums[0];
        vector<int> dp(nums.size(),-1);
        return max(knapsack(nums,nums.size()-1,dp),knapsack(nums,nums.size()-2,dp));
    }
    
    int knapsack(vector<int>& nums,int n,vector<int>& dp)
    {
        if(n>=0 && dp[n]!=-1)
            return dp[n];
        if(n>=0)
        {
            dp[n]=max(knapsack(nums,n-2,dp)+nums[n],knapsack(nums,n-1,dp));
            return dp[n];
        }
        return 0;
    }
};
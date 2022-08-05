class Solution {
    private:
    int f(int target, vector<int> &nums, vector<int> &dp)
    {
        if(target == 0) return 1;
        if(dp[target]!=-1) return dp[target];
        
        int ans = 0;
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]<=target)
                ans += f(target-nums[i],nums,dp);
        }
        return dp[target] = ans;
    }
public:
    int combinationSum4(vector<int>& nums, int target) {
        
        int n = nums.size();
        vector<int> dp(target+1,-1);
        return f(target,nums,dp);
    }
};

class Solution {
    private:
    int f(int ind, vector<int> &nums, vector<int> &dp)
    {
        if(ind == nums.size()-1) return nums[ind];
        if(ind > nums.size()-1) return 0;
        
        if(dp[ind] != -1) return dp[ind];
        
        int one = nums[ind]+f(ind+1,nums,dp);
        int two = nums[ind]+f(ind+2,nums,dp);
        return dp[ind] = min(one,two);
    }
public:
    int minCostClimbingStairs(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> dp(n+1,-1);
        int ans1 = f(0,nums,dp);
        int ans2 = f(1,nums,dp);
        cout<<ans1<<" "<<ans2<<endl;
        if(ans1<ans2) return ans1;
        return ans2;
    }
};

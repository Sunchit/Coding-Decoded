class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n=nums.size();
        if(n<3) return 0;
        vector<int> dp(n,0);
        int diff=nums[1]-nums[0],start=0;
        for(int i=2;i<nums.size();i++)
        {
            if(nums[i]-nums[i-1]!=diff)
            {
                diff=nums[i]-nums[i-1];
                start=i-1;
                dp[i]=dp[i-1];
            }
            else
            {
                if(i-start+1<3) dp[i]=dp[i-1];
                else
                {
                    dp[i]=dp[i-1]+(i-start+1)-3+1;
                }
            }
        }
        return dp.back();
    }
};
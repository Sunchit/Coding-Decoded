class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        vector<int> dp(nums.size(),1);
        int max_count=countLDS(dp,nums);
        // cout<<max_count;
        return getlds(nums,dp,max_count);
    }
    
    vector<int> getlds(vector<int>& nums,vector<int> dp,int& max_count)
    {
        vector<int> res;
        int prev=-1;
        for(int i=dp.size()-1;i>=0;i--)
        {
            // cout<<dp[i]<<endl;
            if(dp[i]==max_count && (prev==-1 || (prev%nums[i])==0))
            {
                
                res.push_back(nums[i]);
                prev=nums[i];
                --max_count;
            }
        }
        
        reverse(begin(res),end(res));
        return res;
    }
    int countLDS(vector<int>& dp,vector<int>& nums)
    {
        sort(begin(nums),end(nums));

        for(int i=1;i<nums.size();i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0)
                    dp[i]=max(dp[i],dp[j]+1);
            }
        }
        
        return *max_element(begin(dp),end(dp));
    }
};
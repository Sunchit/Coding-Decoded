// author:shyam2520

class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> ans(nums.size(),1);
        for(int i=nums.size()-2;i>=0;i--)
            ans[i]=nums[i+1]*ans[i+1];
        int prefix=1;
        for(int i=0;i<nums.size();i++)
        {
            ans[i]=prefix*ans[i];
            prefix*=nums[i];
        }
        
        return ans;
    }
};
// author:shyam2520
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res=nums[0],sum=nums[0];
        for(int i=1;i<nums.size();i++)
        {
            sum=max(sum+nums[i],nums[i]);
            res=max(res,sum);
        }
        return res;
    }
};
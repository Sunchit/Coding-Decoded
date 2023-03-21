class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        
        long long ans = 0, cur = 0;
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]==0) cur++;
            else cur = 0;
            ans += cur;
        }
        return ans;
    }
};

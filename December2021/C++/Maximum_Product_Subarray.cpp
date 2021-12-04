class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int max_so_far=nums[0],curr_max=nums[0],curr_min=nums[0];
        for(int i=1;i<nums.size();i++)
        {
            int temp=curr_max;
            curr_max=max({nums[i],temp*nums[i],curr_min*nums[i]});
            curr_min=min({nums[i],temp*nums[i],curr_min*nums[i]});
            max_so_far=max({max_so_far,curr_max,curr_min});
        }
        return max_so_far;
    }
};
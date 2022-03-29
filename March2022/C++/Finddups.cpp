class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        for(auto& i:nums)
        {
            if(nums[abs(i)]<0) return abs(i);
            else nums[abs(i)]=-nums[abs(i)];
        }
        return -1;
    }
};
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int mid,l=0,r=nums.size()-1;
        while(l<r)
        {
            mid=l+(r-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>target) r=mid;
            else l=mid+1;
        }

        return nums[l]==target?l:nums[l]>target?l:l+1;
    }
};
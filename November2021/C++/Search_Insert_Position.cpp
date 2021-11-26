class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int l=0,r=nums.size()-1;
        int mid;
        while(l<=r)
        {
            mid=l+(r-l)/2;
            if(nums[mid]<target)
                l=mid+1;
            else
                r=mid-1;
        }
        return l;
    }
};
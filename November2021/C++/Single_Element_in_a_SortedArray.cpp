//author : shyam2520
// https://leetcode.com/problems/single-element-in-a-sorted-array/
class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int l=0,r=nums.size()-1;
        int mid;
        while(l<r)
        {
            mid=l+(r-l)/2;
            if(mid%2)
            {
                if(nums[mid-1]==nums[mid])
                    l=mid+1;
                else
                    r=mid;
            }
            else 
            {
                if(nums[mid+1]==nums[mid])
                    l=mid+1;
                else
                    r=mid;
            }
            
        }
        return nums[l];
    }
};
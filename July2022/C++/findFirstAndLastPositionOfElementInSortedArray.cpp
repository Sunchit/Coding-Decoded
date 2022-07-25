class Solution {
    private:
    int search(vector<int> &nums, int x)
    {
        int l = 0, h = nums.size()-1;
        while(l<=h)
        {
            int m = l+(h-l)/2;
            if(nums[m]<x) l = m+1;
            else h = m-1;
        }
        return l;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        int first = search(nums,target);
        int last = search(nums,target+1)-1;
        if(first<=last and nums[first]==target) return{first,last};
        return {-1,-1};
    }
};

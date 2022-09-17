class Solution {
private:
    int binarySearch(vector<int>& nums, int target, bool findStartIndex) {
        int start = 0;
        int end = nums.size() - 1;
        int ans = -1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        
        return ans;
    }
    
public:
    // TC: O(logn)
    // SC: O(1)
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ans(2, -1);
        
        ans[0] = binarySearch(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = binarySearch(nums, target, false);
        }
        
        return ans;
    }
};

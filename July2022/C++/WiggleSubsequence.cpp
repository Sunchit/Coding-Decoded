class Solution {
public:
    // TC: O(n)
    // SC: O(1)
    int wiggleMaxLength(vector<int>& nums) {
        int n = nums.size();
        
        int up = 1;
        int down = 1;
        
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {    // uphill case
                up = down + 1;
            } else if (nums[i] > nums[i + 1]) {    // downhill case
                down = up + 1;
            }
        }
        
        return max(up, down);
    }
};

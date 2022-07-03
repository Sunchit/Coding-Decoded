
// @saorav21994
// TC : O(n)
// SC : O(1)

class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        // Keep tracking the last down subsequence and up subsequence and at end return max of all of them.
        int up = 1, down = 1;
        
        // first element does not matter so, up = down = 1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1])
                up = down + 1;          // previous down as current is > previous
            else if (nums[i] < nums[i-1])
                down = up + 1;          // previous up as current is < previous
            // else for equal don't need to do anything
        }
        return Math.max(up, down);
    }
}

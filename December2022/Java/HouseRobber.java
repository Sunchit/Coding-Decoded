// @saorav21994

class Solution {
    public int rob(int[] nums) {
        int l = nums.length;
        if (l == 1)
            return nums[0];
        int dp2 = nums[0];
        int dp1 = Math.max(nums[0], nums[1]);
        int dp = dp1;
        for (int i = 2; i < l; i++) {
            dp = Math.max(dp2 + nums[i], dp1);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp;
    }
}

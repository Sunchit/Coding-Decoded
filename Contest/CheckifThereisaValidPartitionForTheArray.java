// https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
// @author: anuj0503
class Solution {
    int[] dp;
    public  boolean validPartition(int[] nums) {
        dp = new int[nums.length];

        isValid(0, nums, nums.length);

        return dp[0] == 1;
    }

    private int isValid(int index, int[] nums, int n){
        if(index >= n)
            return 1;

        if(dp[index] != 0){
            return dp[index];
        }

        if(index + 1 < n){
            if(nums[index] == nums[index + 1]){
                dp[index] = isValid(index + 2, nums, n);
            }
        }

        if(dp[index] == 1)
            return dp[index];

        if(index + 2 < n){
            if(nums[index] + 1 == nums[index + 1] && nums[index] + 2 == nums[index + 2]){
                dp[index] =  isValid(index + 3, nums, n);
            }

            if(dp[index] == 1)
                return dp[index];

            if(nums[index] == nums[index + 1] && nums[index] == nums[index + 2]){
                dp[index] =  isValid(index + 3, nums, n);
            }

            if(dp[index] == 1)
                return dp[index];
        }

        dp[index] = -1;
        return dp[index];
    }
}

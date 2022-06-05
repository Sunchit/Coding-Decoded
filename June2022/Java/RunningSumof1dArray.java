class Solution {
    // TC : O(n)
    // SC : O(1)
    public int[] runningSum(int[] nums) {
        int rSum = 0;
        for(int i=0;i<nums.length;i++){
            rSum = rSum + nums[i];
            nums[i] = rSum;
        }
        return nums;
    }
}
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int mxCount = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==1)  {
                nums[i] += nums[i-1];
            }
            mxCount = Math.max(mxCount, nums[i]);
        }

        return mxCount;
    }
}
class Solution {
    // TC : O(n)
    // SC : O(1)
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0;
        int start =0;
        int end = 0;
        int windowCount = 0;
        while(end<nums.length){

            // el within the range recalculate the window
            if(nums[end]>=left && nums[end]<=right) {

                windowCount = end-start+1;
            }
            // el outside the right range, update start  + reset window
            else if(nums[end]>right){
                windowCount = 0;
                start = end +1;
            } else  if(nums[end] < left){
                // el less than range use previous window
                windowCount = windowCount;
            }


            res +=  windowCount;
            end++;
        }


        return res;

    }
}
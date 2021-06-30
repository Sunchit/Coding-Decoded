class Solution {

    // TC : O(n)
    // SC : O(1)
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int maxLen = 0;
        int flippedOnes = 0;
        while(end<nums.length){
            if(nums[end] ==1){
                end++;
            } else {
                // nums[end] == 0
                if(flippedOnes<k) {
                    flippedOnes++;
                    end++;
                } else {
                    // reduce some flips
                    while(flippedOnes>=k) {
                        if(nums[start] == 0) {
                            flippedOnes--;

                        }
                         start++;
                    }
                }
            }
           // System.out.println(end + " "+ start);
            maxLen = Math.max(maxLen, end-start);
        }
        return maxLen;
    }
}
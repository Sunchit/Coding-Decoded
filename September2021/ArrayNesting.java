//https://www.youtube.com/playlist?list=PLEI-q7w3s9gTNU412xW8kV1xQ8upnrN0a

class Solution {
    // TC : O(n)
    // SC : O(1)
    public int arrayNesting(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0)
                continue;
            max = Math.max(max, calcLength(nums, i));
        }
        return max;
    }

    private int calcLength(int[] nums, int start) {

        if(start<0 || start==nums.length || nums[start]<0){
            return 0;
        }

        int nextValue = nums[start];
        nums[start] = Integer.MIN_VALUE;

        return 1 + calcLength(nums, nextValue);

    }
}
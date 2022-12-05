// @saorav21994

class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int l = nums.length;
        long [] csum = new long[l];

        csum[0] = nums[0];
        for (int i = 1; i < l; i++) {
            csum[i] = csum[i-1] + nums[i]; 
        }

        long min = Long.MAX_VALUE;
        int ridx = -1;

        for (int i = 0; i < l; i++) {
            long lsum = csum[i];
            long rsum = csum[l-1] - csum[i];
            long lavg = lsum/(i+1);
            long ravg = (rsum == 0) ? 0 : rsum/(l-i-1);
            long diff = Math.abs(lavg-ravg);
            if (diff < min) {
                min = diff;
                ridx = i;
            }

            
        }

        return ridx;

    }
}

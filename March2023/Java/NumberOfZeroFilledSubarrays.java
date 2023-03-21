// @saorav21994

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int l = nums.length;
        int c0 = 0; // cumulative zeros
        long sa = 0l;   
        for (int i = 0; i < l; i++) {
            if (nums[i] == 0 && (i > 0 && nums[i-1] == 0)) {
                c0 += 1;
            }
            else if (nums[i] == 0) {
                c0 = 1;
            }
            else {
                if (c0 > 0) {
                    sa += (long) ((long)c0*(long)(c0+1))/2l;
                    c0 = 0;
                }
            }
        }
        if (c0 > 0) {
            sa += (long) ((long)c0*(long)(c0+1))/2l;
            c0 = 0;
        }
        return sa;
    }
}

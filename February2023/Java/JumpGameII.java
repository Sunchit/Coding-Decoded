// @saorav21994

class Solution {
    public int jump(int[] nums) {
        int l = nums.length - 1;
        if (l == 0) return 0;
        int jump = 0;   // for any array length more than 1 atleast 1 jump will be required
        int idx = 0;
        int [] dst = new int[l+1];
        dst[0] = nums[0];
        if (dst[0] >= l) return 1;
        for (int i = 1; i < l; i++) {
            dst[i] = Math.max(dst[i-1], i + nums[i]);
            idx = i;
            if (dst[i] >= l) {
                jump += 1;
                break;
            }
        }
        int i = idx;
        while (idx > 0) {
            i -= 1;
            int flag = 0;
            while (i >= 0 && dst[i] >= idx) {
                
                i -= 1;
                if (i == -1) flag = 1;
            }
            idx = i+1;
            jump += 1;
            i = idx;
            if (flag == 1) break;
        }
        return jump;
    }
}

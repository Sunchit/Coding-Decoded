
// @saorav21994
// Easy

class Solution {
    public int singleNumber(int[] nums) {
        int l = nums.length;
        int res = 0;
        for (int i = 0; i < l; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}

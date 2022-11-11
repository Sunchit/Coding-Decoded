// @saorav21994

class Solution {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        if (l == 0 || l == 1) {
            return l;
        }
        int i = 0, j = 0;
        int count = 1;
        for (j = 1; j < l; j++) {
            if (nums[i] == nums[j]) {
                // Do nothing
            }
            else {
                i += 1;
                count += 1;
                nums[i] = nums[j];
            }
        }
        return count;
    }
}

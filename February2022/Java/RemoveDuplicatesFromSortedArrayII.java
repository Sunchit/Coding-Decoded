// Author - @saorav21994
// TC - O(n)



class Solution {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        int prev = nums[0];
        int cnt = 1;    // maximum duplicates allowed track cnt (= 2)
        int pidx = 1;   // index on which element to be replaced if needed
        for (int i = 1; i < l; i++) {
            if (prev == nums[i]) {
                if (cnt < 2) {
                    cnt += 1;
                    nums[pidx] = nums[i];
                    pidx += 1;
                }
                else {      // cnt >= 2, no more duplicate allowed
                    // pass
                }
            }
            else {
                prev = nums[i];
                cnt = 1;
                nums[pidx] = nums[i];
                pidx += 1;
            }
        }
        return pidx;
    }
}

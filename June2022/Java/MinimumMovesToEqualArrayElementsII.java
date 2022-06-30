
// @saorav21994
// TC : O(nlogn)
// SC : O(1)

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;
        int cnt = 0;
        while (l < r) {
            cnt += Math.abs(nums[l] - nums[r]);     // avg of both
            l += 1;
            r -= 1;
        }
        return cnt;
    }
}

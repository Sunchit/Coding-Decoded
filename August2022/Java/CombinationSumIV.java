
// @saorav21994
// TC : O(target*nums.length)
// SC : O(target)

// 0-1 knapsack like appproach 

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int [] res = new int[target+1];
        res[0] = 1;
        int l = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            int j = 0;
            while (j < l && nums[j] <= i) {
                res[i] += res[i-nums[j]];
                j += 1;
            }
        }
        return res[target];
    }
}

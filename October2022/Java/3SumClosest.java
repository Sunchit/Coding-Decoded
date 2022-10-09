// @saorav21994
// Sort + 2 pointer approach

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int l = nums.length;
        int d = Integer.MAX_VALUE;
        for (int i = 0; i < l; i++) {
            int low = i+1, high = l-1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target-sum) < Math.abs(d)) {
                    d = target-sum;
                }
                if (sum < target)
                    low += 1;
                else
                    high -= 1;
            }
        }
        return (target-d);
    }
}

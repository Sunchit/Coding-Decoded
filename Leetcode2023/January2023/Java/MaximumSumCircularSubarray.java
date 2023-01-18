class Solution {

     public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0];
        int curMax = 0;
        int minSum = nums[0];
        int curMin = 0;
        for (int el : nums) {
            // Max value of MAx Subarray sum
            curMax = Math.max(curMax + el, el);
            maxSum = Math.max(maxSum, curMax);

            // Min value of Min Subarray sum
            curMin = Math.min(curMin + el, el);
            minSum = Math.min(minSum, curMin);

            totalSum += el;
        }
        return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }
}

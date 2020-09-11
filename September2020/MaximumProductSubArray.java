class MaximumProductSubArray {
    // Space => O(1), Time Complexity => O(n)
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            int copyMaxSoFar = maxSoFar;
            int el = nums[i];
            maxSoFar = Math.max(el, Math.max(el*maxSoFar, el*minSoFar));

            minSoFar = Math.min(el, Math.min(el*copyMaxSoFar, el*minSoFar));
            res = Math.max(res, maxSoFar);
        }
        return res;
    }
}
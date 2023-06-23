class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        for (int i = k; i < (n - k); ++i) {
            int leftBound = i - k, rightBound = i + k;
            long sum = prefix[rightBound + 1] - prefix[leftBound];
            int avg = (int) (sum / (2 * k + 1));
            ans[i] = avg;
        }

        return ans;
    }
}

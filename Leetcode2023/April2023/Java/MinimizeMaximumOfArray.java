class Solution {
    public int minimizeArrayValue(int[] nums) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        for (int it : nums) {
            end = Math.max(end, it);   
        }
        
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean isPossible = helper(nums, mid);
            if (isPossible) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean helper(int[] nums, int expectedMax) {
        int n = nums.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > expectedMax) {
                return false;
            }
            
            long buffer = expectedMax - arr[i];
            arr[i + 1] -= buffer;
        }
        
        return arr[n - 1] <= expectedMax;
    }
}

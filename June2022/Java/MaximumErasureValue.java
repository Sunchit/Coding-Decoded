
// @saorav21994
// TC : O(n)
// SC : O(max(nums[index]))

// Sliding window with hashing

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int [] hash = new int[100002];
        int i = 0;
        int j = 0;
        int sum = 0;
        int res = 0;
        int l = nums.length;
        while (true) {
            int flag1 = 0;
            int flag2 = 0;
            int end = 0;
            while (i < l) {
                flag1 = 1;
                hash[nums[i]] += 1;
                sum += nums[i];
                i += 1;
                if (hash[nums[i-1]] > 1) {
                    break;
                } 
                res = Math.max(res, sum);
                if ((i-1) == l-1) {
                    end = 1;
                }
            }
            while (j < i && end == 0) {
                flag2 = 1;
                sum -= nums[j];
                hash[nums[j]] -= 1;
                if (hash[nums[j]] == 1) {
                    end = 1;
                }
                j += 1;               
            }
            if (flag1 == 0 && flag2 == 0) break;
        }
        return res;
    }
}

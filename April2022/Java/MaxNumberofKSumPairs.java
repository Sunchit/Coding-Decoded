// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int maxOperations(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;
        Arrays.sort(nums);
        int ans = 0;
        while (i < j) {
            if (nums[i] + nums[j] < k) {
                i++;
            } else if (nums[i] + nums[j] > k) {
                j--;
            } else {
                ans++;
                i++;
                j--;
            }

        }

        return ans;
    }
}
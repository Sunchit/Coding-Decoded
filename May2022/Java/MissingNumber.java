// @saorav21994 
// TC : O(n)
// SC : O(1)

class Solution {
    public int missingNumber(int[] nums) {
        int l = nums.length;
        int tsum = l * (l+1) / 2;
        int csum = 0;
        for (int n : nums) {
            csum += n;
        }
        return tsum-csum;
    }
}

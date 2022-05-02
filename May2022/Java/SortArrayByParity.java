
// @saorav21994
// TC : O(n) - 1 pass
// SC : O(1)
// 2 - pointer approach with 1 pass

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = nums.length;
        
        int i = -1;
        int j = 0;
        
        while (j < l) {
            if (nums[j]%2 == 0) {
                i += 1;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            j += 1;
        }
        
        return nums;
    }
}

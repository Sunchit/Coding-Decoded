
// @saorav21994
// TC : O(n)
// SC : O(1)

class Solution {
    public int minOperations(int[] nums, int x) {
        
        int l = nums.length;
        int arraySum = 0;
        
        for (int num : nums) {
            arraySum += num;
        }
        
        int target = arraySum - x;
        
        if (target == 0) {          // all number needs to be removed to achieve x
            return l;   
        }
        
        int res = -1;
        int left = 0;
        int curSum = 0;
        
        // find the longest sub-array which sums to target (=L, say). Then ans = nums.length-L
        
        for (int i = 0; i < l; i++) {
            
            curSum += nums[i];
            while (left < i && curSum > target) {     // This step can only be done because the array contains all positive elements
                curSum -= nums[left++];
            }
            
            if (target == curSum) {
                res = Math.max(res, i-left+1);
            }
            
        }
        
        return (res == -1) ? res : l-res;
        
    }
}

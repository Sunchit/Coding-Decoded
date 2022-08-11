// https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
// @author: anuj0503
class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long prev = nums[n - 1];
        long result = 0;
        
        for(int i = n - 2; i >= 0; i--){
            long count = (nums[i]/prev);
            
            if(nums[i]%prev != 0){
                count++;
                prev = nums[i]/count;
            }
            
            result += (count - 1);
        }
        
        return result;
    }
}

// https://leetcode.com/problems/number-of-arithmetic-triplets/
// @author: anuj0503
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        
        for(int num : nums) set.add(num);
        
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            
            if(set.contains(num + diff) && set.contains(num + 2 * diff)){
                count++;
            }
        }
        
        return count;
    }
}

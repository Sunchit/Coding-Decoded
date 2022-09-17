class Solution {
    // TC : O(nums)
    // SC : O(1)
    public int[] numberOfPairs(int[] nums) {
        int[] freq = new int[101];
        for(int el: nums){
            freq[el]++;
        }
        int pairs = 0;
        int singles = 0;
        for(int fq : freq){
            pairs += fq/2;
            singles += fq%2 ;
        }
        return new int[] {pairs, singles};
    }
}

// https://leetcode.com/problems/maximum-number-of-pairs-in-array/
// @author: anuj0503
class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] freq = new int[101];
        
        for(int i = 0; i < nums.length; i++){
            freq[nums[i]]++;
        }
        
        int count = 0;
        
        for(int i = 0; i <= 100; i++){
            count += freq[i]/2;
        }
        
        int[] result = new int[]{count, nums.length - 2*count};
        
        return result;
    }
}

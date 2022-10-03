// https://leetcode.com/problems/bitwise-xor-of-all-pairings/
// @author: anuj0503
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int result = 0;
        if(n%2 == 0 && m%2 == 0){
            result = 0;
        } else if (n%2 == 0) {
            for(int num : nums1){
                result ^= num;
            }
        } else if (m%2 == 0) {
            for(int num : nums2){
                result ^= num;
            }
        } else {
            for(int num : nums1){
                result ^= num;
            }

            for(int num : nums2){
                result ^= num;
            }
        }

        return result;
    }
}

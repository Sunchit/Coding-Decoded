// https://leetcode.com/problems/number-of-zero-filled-subarrays/
// @author: anuj0503
public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long result = 0;
        for(int i = 0; i < n; i++){
            long count = 0;

            while(i < n && nums[i] == 0){
                count++; i++;
            }
            result += ((count)*(count+1))/2;
        }

        return result;
    }
}

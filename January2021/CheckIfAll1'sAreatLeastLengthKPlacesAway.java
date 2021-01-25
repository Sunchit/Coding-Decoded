class Solution {
    // TC : O(n)
    // SC : O(1)
    public boolean kLengthApart(int[] nums, int k) {
        int prev1Index = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                if(prev1Index  != Integer.MIN_VALUE && i - prev1Index -1<k){
                    return false;
                }
                prev1Index = i;
            }
        }
        return true;
    }
}
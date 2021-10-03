class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int iMaxReach = nums[0];
        int i = 1;
        while(iMaxReach>=i) {
            if(iMaxReach>=nums.length-1){
                return true;
            }
            iMaxReach = Math.max(nums[i] +i , iMaxReach);
            i++;

        }
        return false;
    }
}
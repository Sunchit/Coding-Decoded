// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int triangularSum(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] nn=new int[nums.length-1];
        for(int i=0;i<nn.length;i++){
            nn[i]=(nums[i]+nums[i+1])%10;
        }
        return triangularSum(nn);
    }
}
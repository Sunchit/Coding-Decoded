// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int findClosestNumber(int[] nums) {
        int val=Integer.MIN_VALUE;
        int diff=Integer.MAX_VALUE;
        for(int v:nums){
            int h=Math.abs(v);
            if((h-0)<diff){
                diff=(h-0);
                val=v;
            }else if(h-0==diff){
                val=Math.max(val,v);
            }
        }
        
        return val;
    }
}
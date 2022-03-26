// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var i:Int=0
        var j:Int=nums.size-1
        while(i<=j){
            var m:Int=(i+j)/2
            if(nums[m]==target){
                return m
            }else if(nums[m]>target){
                j=m-1
            }else{
                i=m+1
            }
        }
        
        return -1
    }
}
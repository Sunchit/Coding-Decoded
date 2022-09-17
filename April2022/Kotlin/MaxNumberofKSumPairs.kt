// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        var i:Int=0
        var j:Int=nums.size-1
        nums.sort()
        var ans:Int=0
       while(i<j){
               if(nums[i]+nums[j]<k){
                   i++
               }else if(nums[i]+nums[j]>k){
                   j--
               }else{
                   ans++
                   i++
                   j--
               }
           
       }
        
        return ans
    }
}
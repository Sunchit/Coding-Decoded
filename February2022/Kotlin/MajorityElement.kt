//Author: Shobhit Behl (LC: shobhitbruh)
//Naive Solution using HashMap
class Solution {
    fun majorityElement(nums: IntArray): Int {
        var hm : HashMap<Int, Int> = HashMap<Int, Int> ()
        
        for(i in nums.indices){
            hm.put(nums[i],hm.getOrDefault(nums[i], 0)+1)
        }
        for(i in nums.indices){
            if(hm.get(nums[i])?.compareTo(nums.size/2)==1){
               return nums[i]
            }
        }

        
        return 0
    }
}
//Optimized Solution Using O(1) space
class Solution {
    fun majorityElement(nums: IntArray): Int {
        var p=nums[0];
        var f=1;
        
        for(i in 1..nums.size-1){
            if(nums[i]!=p&&f>0){
                f--
            }else if(f==0){
                p=nums[i]
                f=1;
            }else if(nums[i]==p){
                f++
            }
        }
        
        return p
    }
}
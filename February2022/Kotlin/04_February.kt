// Created by LeetCode : shobhitbruh

class Solution {
    fun findMaxLength(nums: IntArray): Int {
        val counts=mutableMapOf(0 to -1)
        var max=0
        var acc=0
        
        for((i,num) in nums.withIndex()){
            acc+=if(num==0)-1 else +1
            
            if(counts.containsKey(acc)){
                max=maxOf(max,i-counts[acc]!!)
            }else{
                counts[acc]=i
            }
        }
        
        return max;
    }
}
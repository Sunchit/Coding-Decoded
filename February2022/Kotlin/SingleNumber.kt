// Created by LeetCode : shobhitbruh
class Solution {
    fun singleNumber(nums: IntArray): Int {
       var x = 0
       for (`val` in nums) {
           x = x xor `val`
       }
       return x
   }
}
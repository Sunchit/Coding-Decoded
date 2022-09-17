// Author : Shobhit Behl(shobhitbruh)
// T:O(N) 
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var ans = 0
        var j = 0
        var f = 0
        var l = 0
        for (i in nums.indices) {
            if (nums[i] == l && f == 2) {
                continue
            } else {
                if (nums[i] != l) f = 0
                nums[j] = nums[i]
                f++
                l = nums[i]
                ans++
                j++
            }
        }
        return ans
    }
}
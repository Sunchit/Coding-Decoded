// Author : Shobhit Behl (LC : shobhitbruh)
class Solution {
    fun findPairs(nums: IntArray, k: Int): Int {
        val hm = HashMap<Int, Int>()
        var c = 0
        for (i in nums.indices) {
            hm[nums[i]] = hm.getOrDefault(nums[i], 0) + 1
        }
        if (k != 0) {
            for (`val` in hm.keys) {
                if (hm.containsKey(`val` + k)) {
                    c++
                }
            }
        } else {
            for (`val` in hm.keys) {
                if (hm[`val`]!! > 1) {
                    c++
                }
            }
        }
        return c
    }
}
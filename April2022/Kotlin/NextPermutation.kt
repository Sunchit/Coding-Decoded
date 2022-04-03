// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun nextPermutation(nums: IntArray) {
        val x = ArrayList<Int>()
        var p = 0
        var q = 0
        for (i in nums.size - 2 downTo 0) {
            if (nums[i] < nums[i + 1]) {
                p = i
                q++
                break
            }
        }
        if (q == 0) {
            nums.sort()
            return
        }
        var z = Int.MAX_VALUE
        var idx = -1
        for (i in nums.size - 1 downTo p + 1) {
            if (nums[i] < z && nums[p] < nums[i]) {
                z = nums[i]
                idx = i
            }
        }
        if (idx != -1) {
            val temp = nums[p]
            nums[p] = nums[idx]
            nums[idx] = temp
            for (i in nums.size - 1 downTo p + 1) {
                x.add(nums[i])
            }
            x.sort()
            var j = 0
            for (i in p + 1 until nums.size) {
                nums[i] = x[j]
                j++
            }
        }
    }
}
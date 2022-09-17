//Author Shobhit Behl(LC:shobhitbruh)
class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val ans: MutableList<List<Int>> = ArrayList()
        val al: MutableList<Int> = ArrayList()
        rec(al, ans, nums, nums.size - 1)
        return ans
    }

    fun rec(al: MutableList<Int>, ans: MutableList<List<Int>>, nums: IntArray, i: Int) {
        if (i == -1) {
            val ak: MutableList<Int> = ArrayList()
            for (j in al.indices) {
                ak.add(al[j])
            }
            ans.add(ak)
            return
        }
        rec(al, ans, nums, i - 1)
        al.add(nums[i])
        rec(al, ans, nums, i - 1)
        al.removeAt(al.size - 1)
    }
}
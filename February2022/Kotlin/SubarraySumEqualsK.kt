class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val hs = HashMap<Int, Int>()
        hs[0] = 1
        var c = 0
        val ts = IntArray(nums.size)
        for (i in nums.indices) {
            ts[i] = nums[i]
            if (i > 0) {
                ts[i] += ts[i - 1]
            }
            if (hs.containsKey(ts[i] - k)) {
                c += hs[ts[i] - k]!!
            }
            hs[ts[i]] = hs.getOrDefault(ts[i], 0) + 1
        }
        return c
    }
}
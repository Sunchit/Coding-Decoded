// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        var hm = HashMap<Int,HashSet<Int>>()
        for(i in nums.indices){
            if(!hm.containsKey(nums[i])){
                var hs= HashSet<Int>()
                hs.add(i)
                hm[nums[i]]=hs
            }else{
                hm[nums[i]]!!.add(i)
            }
        }
         var c = 0
        for (i in 2 until nums.size) {
            val d = nums[i] - nums[i - 1]
            var k = 2
            while (i - k >= 0 && hm.containsKey(nums[i] - k * d) && hm[nums[i] - k * d]!!.contains(i - k)) {
                c++
                k++
            }
        }
        return c
    }
}
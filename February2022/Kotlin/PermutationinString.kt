// Author : Shobhit Behl (LC : shobhitbruh)
class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) {
            return false
        }
        val hm = HashMap<Char, Int>()
        for (i in 0 until s1.length) {
            hm[s1[i]] = hm.getOrDefault(s1[i], 0) + 1
        }
        val a = HashMap<Char, Int>()
        var i = 0
        var j = 0
        while (j < s2.length) {
            a[s2[j]] = a.getOrDefault(s2[j], 0) + 1
            if (j < s1.length - 1) {
                j++
                continue
            }
            if (a == hm) {
                return true
            }
            a[s2[i]] = a[s2[i]]!! - 1
            if (a[s2[i]] == 0) {
                a.remove(s2[i])
            }
            i++
            j++
        }
        return false
    }
}
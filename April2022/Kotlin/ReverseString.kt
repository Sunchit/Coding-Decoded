// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun reverseString(s: CharArray) {
        val sb = StringBuilder()
        for (x in s) {
            sb.append(x)
        }
        val y = sb.reverse().toString().toCharArray()
        for (i in s.indices) {
            s[i] = y[i]
        }
    }
}
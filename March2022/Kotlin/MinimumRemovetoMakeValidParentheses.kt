// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
     inner class Pair internal constructor(var pos: Int, var x: Char)

    fun minRemoveToMakeValid(s: String): String {
        val st = Stack<Pair>()
        val hs = HashSet<Int>()
        for (i in 0 until s.length) {
            if (s[i] == '(') {
                st.push(Pair(i, s[i]))
            } else if (s[i] == ')') {
                if (st.size > 0 && st.peek().x == '(') {
                    st.pop()
                } else {
                    hs.add(i)
                }
            }
        }
        while (st.size > 0) {
            val m = st.pop()
            hs.add(m.pos)
        }
        val sb = StringBuilder()
        for (i in 0 until s.length) {
            if (!hs.contains(i)) {
                sb.append(s[i])
            }
        }
        return sb.toString()
    }
}
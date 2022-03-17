// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun scoreOfParentheses(s: String): Int {
        val li = LinkedList<String>()
        for (i in 0 until s.length) {
            val ch = s[i]
            if (ch == '(') {
                var u = ""
                u += ch
                li.addFirst(u)
            } else {
                var x = 0
                while (li.size > 0 && li.first != "(") {
                    val t = li.removeFirst()
                    x += t.toInt()
                }
                li.removeFirst()
                if (x != 0) {
                    x *= 2
                    val g = StringBuilder()
                    g.append(x)
                    li.addFirst(g.toString())
                } else {
                    li.addFirst("1")
                }
            }
        }
        var k = 0
        while (li.size > 0) {
            k += li.removeLast().toInt()
        }
        return k
    }
}
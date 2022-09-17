// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun isValid(s: String): Boolean {
        val li = LinkedList<Char>()
        for (i in 0 until s.length) {
            if (s[i] == '(' || s[i] == '[' || s[i] == '{') {
                li.addFirst(s[i])
            } else if (s[i] == ')' && li.size > 0 && li.first == '(') {
                li.removeFirst()
            } else if (s[i] == ']' && li.size > 0 && li.first == '[') {
                li.removeFirst()
            } else if (s[i] == '}' && li.size > 0 && li.first == '{') {
                li.removeFirst()
            } else {
                return false
            }
        }
        return li.size == 0
    }
}
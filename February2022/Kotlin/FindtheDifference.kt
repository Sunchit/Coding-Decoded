//Author: Shobhit Behl (LeetCode:shobhitbruh)

//HashMap Solution (naive approach)

public class Solution {
    fun findTheDifference(s: String, t: String): Char {
        val hs = HashMap<Char, Int>()
        val arr = s.toCharArray()
        for (x in arr) {
            hs[x] = hs.getOrDefault(x, 0) + 1
        }
        val abc = t.toCharArray()
        var ans = '&'
        for (x in abc) {
            if (hs.containsKey(x)) {
                hs[x] = hs[x]!! - 1
                if (hs[x] == 0) {
                    hs.remove(x)
                }
            } else {
                ans = x
                break
            }
        }
        return ans
    }
}


// (Optimized) Bit-Manipulation Solution T:O(n+m), where n is s.length() and m is t.length();

public class Solution {
    fun findTheDifference(s: String, t: String): Char {
        var c = 0.toChar()
        for (i in 0 until s.length) {
            c = (c.toInt() xor s[i].toInt()).toChar()
        }
        for (i in 0 until t.length) {
            c = (c.toInt() xor t[i].toInt()).toChar()
        }
        return c
    }
}

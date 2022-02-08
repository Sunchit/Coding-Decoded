// Author Shobhit Behl( LC : shobhitbruh)
class Solution {
    fun addDigits(num: Int): Int {
        var n = Integer.toString(num).toCharArray()
        var sum = num
        while (n.size > 1) {
            sum = 0
            for (x in n) {
                sum += x - '0'
            }
            n = Integer.toString(sum).toCharArray()
        }
        return sum
    }
}
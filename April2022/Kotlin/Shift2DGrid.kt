// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
         var k = k
        val n = grid.size
        val m: Int = grid[0].size
        val li = LinkedList<Int>()
        for (i in 0 until n) {
            for (j in 0 until m) {
                li.addLast(grid[i][j])
            }
        }
        while (k-- > 0) {
            val f = li.removeLast()
            li.addFirst(f)
        }
        val al: MutableList<List<Int>> = ArrayList()
        for (i in 0 until n) {
            val g: MutableList<Int> = ArrayList()
            for (j in 0 until m) {
                g.add(li.removeFirst())
            }
            al.add(g)
        }
        return al
    }
}
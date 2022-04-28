// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    class Pair internal constructor(var x: Int, var y: Int, var diff: Int) : Comparable<Pair> {
        override fun compareTo(o: Pair): Int {
            return diff - o.diff
        }
    }

    fun minimumEffortPath(a: Array<IntArray>): Int {
        val pq: PriorityQueue<Pair> = PriorityQueue()
        val v = Array(a.size) { BooleanArray(a[0].size) }
        pq.add(Pair(0, 0, 0))
        while (pq.size > 0) {
            var s: Int = pq.size
            while (s-- > 0) {
                val p: Pair = pq.remove()
                if (p.x == a.size - 1 && p.y == a[0].size - 1) {
                    return p.diff
                }
                v[p.x][p.y] = true
                if (p.x - 1 >= 0 && !v[p.x - 1][p.y]) {
                    pq.add(Pair(p.x - 1, p.y, Math.max(p.diff, Math.abs(a[p.x][p.y] - a[p.x - 1][p.y]))))
                }
                if (p.x + 1 < a.size && !v[p.x + 1][p.y]) {
                    pq.add(Pair(p.x + 1, p.y, Math.max(p.diff, Math.abs(a[p.x][p.y] - a[p.x + 1][p.y]))))
                }
                if (p.y - 1 >= 0 && !v[p.x][p.y - 1]) {
                    pq.add(Pair(p.x, p.y - 1, Math.max(p.diff, Math.abs(a[p.x][p.y] - a[p.x][p.y - 1]))))
                }
                if (p.y + 1 < a[0].size && !v[p.x][p.y + 1]) {
                    pq.add(Pair(p.x, p.y + 1, Math.max(p.diff, Math.abs(a[p.x][p.y] - a[p.x][p.y + 1]))))
                }
            }
        }
        return -1
    }
}
// Author: Shobhit Behl (LC: shobhitbruh)
inner class Pair internal constructor(var x: Int, var y: Int) : Comparable<Pair> {
        override fun compareTo(o: Pair): Int {
            return if (x == o.x) {
                y - o.y
            } else x - o.x
        }
    }

    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        var k = k
        var min: Int = mat[0].size - 1
        val pq: PriorityQueue<Pair?> = PriorityQueue<Pair?>()
        val a = Array(mat.size) { IntArray(2) }
        for (i in mat.indices) {
            var m = 0
            for (j in 0 until mat[0].size-1) {
                if (mat[i][j] == 1) {
                    m++
                } else {
                    break
                }
            }
            min = Math.min(min, m)
            pq.add(Pair(m, i))
        }
        val p = ArrayList<Int>()
        while (k-- > 0 && pq.size > 0) {
            val u = pq.remove()
            p.add(u!!.y)
        }
        return p.stream().mapToInt { i: Int? -> i!! }.toArray()
    }
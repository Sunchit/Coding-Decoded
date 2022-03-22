// Author: Shobhit Behl (LC: shobhitbruh)
class FreqStack() {

    inner class pair internal constructor(var `val`: Int, fr: Int, t: Int) : Comparable<pair> {
        var fr: Int
        var t: Int
        override fun compareTo(x: pair): Int {
            return if (fr != x.fr) {
                x.fr - fr
            } else x.t - t
        }

        init {
            this.fr = hm.getOrDefault(`val`, 0)
            this.t = t
        }
    }

    var c = 0
    var pq: PriorityQueue<pair>
    var hm: HashMap<Int, Int>
    fun push(`val`: Int) {
        val j = hm.getOrDefault(`val`, 0)
        hm[`val`] = j + 1
        pq.add(pair(`val`, hm[`val`]!!, c))
        c++
    }

    fun pop(): Int {
        if (pq.size == 0) {
            return -1
        }
        val a = pq.remove()
        a.fr--
        hm[a.`val`] = a.fr
        if (a.fr == 0) {
            hm.remove(a.`val`)
        }
        return a.`val`
    }

    init {
        hm = HashMap()
        pq = PriorityQueue()
    }

}
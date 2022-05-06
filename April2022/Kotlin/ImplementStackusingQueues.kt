// Author: Shobhit Behl (LC: shobhitbruh)
class MyStack() {
    
    var q1: Queue<Int>
    var q2: Queue<Int>
    fun push(x: Int) {
        q1.add(x)
    }

    fun pop(): Int {
        while (q1.size > 1) {
            q2.add(q1.remove())
        }
        val j: Int = q1.remove()
        while (q2.size > 0) {
            q1.add(q2.remove())
        }
        return j
    }

    fun top(): Int {
        while (q1.size > 1) {
            q2.add(q1.remove())
        }
        val j: Int = q1.remove()
        while (q2.size > 0) {
            q1.add(q2.remove())
        }
        q1.add(j)
        return j
    }

    fun empty(): Boolean {
        return q1.size === 0
    }

    init {
        q1 = LinkedList()
        q2 = LinkedList()
    }
}
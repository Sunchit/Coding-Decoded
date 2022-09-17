// Author: Shobhit Behl (LC: shobhitbruh)
fun copyRandomList(head: Node?): Node? {
        var p = head
        val hm = HashMap<Node?, Node>()
        while (p != null) {
            val x: Node = Node(p.`val`)
            hm[p] = x
            p = p.next
        }
        p = head
        while (p != null) {
            val x = hm[p]
            if (p.next != null) {
                x!!.next = hm[p.next]
            }
            if (p.random != null) {
                x!!.random = hm[p.random]
            }
            p = p.next
        }
        return hm[head]
    }
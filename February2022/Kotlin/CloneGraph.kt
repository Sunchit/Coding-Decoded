class Solution {
    fun cloneGraph(node: Node?): Node? {
      if (node == null) {
            return null
        }
        val li = LinkedList<Node?>()
        val hs = HashMap<Int, Node>()
        val visited = HashSet<Node?>()
        li.addLast(node)
        while (li.size > 0) {
            var s = li.size
            while (s-- > 0) {
                val rem = li.removeFirst()
                if (visited.contains(rem)) {
                    continue
                }
                visited.add(rem)
                var x: Node? = null
                if (!hs.containsKey(rem!!.`val`)) {
                    x = Node(rem.`val`)
                    hs[x.`val`] = x
                } else {
                    x = hs[rem.`val`]
                }
                for (i in rem.neighbors.indices) {
                    var chi: Node? = null
                    if (!hs.containsKey(rem.neighbors[i]!!.`val`)) {
                        chi = Node(rem.neighbors[i]!!.`val`)
                        hs[chi.`val`] = chi
                    } else {
                        chi = hs[rem.neighbors[i]!!.`val`]
                    }
                    x!!.neighbors.add(chi)
                    if (visited.contains(rem.neighbors[i])) {
                        continue
                    }
                    li.addLast(rem.neighbors[i])
                }
            }
        }
        return hs[1] 
    }
}
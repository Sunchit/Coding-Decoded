//Author : Shobhit Behl(LC : shobhitbruh)
class Solution {
    class Pair internal constructor(var node: TreeNode?, st: Int) {
       var st = 0

       init {
           this.st = st
       }
   }

   fun widthOfBinaryTree(root: TreeNode?): Int {
       val pa = LinkedList<Pair>()
       pa.addLast(Pair(root, 0))
       var max = 0
       val f = false
       while (pa.size > 0) {
           var size = pa.size
           val first = pa.first.st
           var last = pa.first.st
           while (size-- > 0) {
               val rem = pa.removeFirst()
               last = rem.st
               if (rem.node!!.left != null) {
                   pa.addLast(Pair(rem.node!!.left, 2 * rem.st + 1))
               }
               if (rem.node!!.right != null) {
                   pa.addLast(Pair(rem.node!!.right, 2 * rem.st + 2))
               }
           }
           max = Math.max(max, last - first + 1)
       }
       return max
   }
}
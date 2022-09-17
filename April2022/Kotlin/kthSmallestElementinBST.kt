// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    var m = 0
    fun kthSmallest(root: TreeNode, k: Int): Int {
        m = k
        return ans(root)
    }

    fun ans(root: TreeNode): Int {
        if (root.left != null) {
            val l = ans(root.left)
            if (m == 0) {
                return l
            }
        }
        m--
        if (m == 0) {
            return root.`val`
        }
        if (root.right != null) {
            val r = ans(root.right)
            if (m == 0) return r
        }
        return 0
    }
}
// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun increasingBST(root: TreeNode?): TreeNode? {
     val al: ArrayList<TreeNode> = ArrayList()
        rec(root, al)
        for (i in al.size - 1 downTo 0) {
            al[i].left = null
            al[i].right = null
            if (i < al.size - 1) {
                al[i].right = al[i + 1]
            }
        }
        return al[0]
    }

    fun rec(root: TreeNode?, al: ArrayList<TreeNode>) {
        if (root == null) {
            return
        }
        rec(root.left, al)
        al.add(root)
        rec(root.right, al)
    }
}
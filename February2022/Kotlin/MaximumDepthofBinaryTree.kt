//Author: Shobhit Behl (LeetCode:shobhitbruh)
class Solution {
    fun maxDepth(root: TreeNode?): Int {
            return if (root == null) {
                0
            } else Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
        }
}
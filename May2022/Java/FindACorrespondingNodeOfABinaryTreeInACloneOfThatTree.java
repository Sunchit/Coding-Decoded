
// @saorav21994
// TC : O(n)
// SC : O(n)
// Simply searched in cloned tree because unique value, otherwise compare node and keep both cloned and original in queue. Can be done in inorder also.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue <TreeNode> q = new LinkedList<TreeNode> ();
        q.add(cloned);
        while (q.isEmpty() == false) {
            TreeNode node = q.poll();
            if (node != null) {
                if (node.val == target.val) {
                    // System.out.println("match");
                    return node;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return target;
    }
}

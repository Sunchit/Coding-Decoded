// @saorav21994

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        
        // < O(n) => O(logn)*O(logn)

        if (root == null)
            return 0;

        TreeNode left, right;
        left = right = root;

        int l = 1, r = 1;      // count of left height ndoes and right height nodes respectively

        while ((left = left.left) != null)
            l += 1;
        while ((right = right.right) != null)
            r += 1;

        if (l == r)
            return (int)Math.pow(2,l) - 1;      // if left and right height is same, then all nodes between them will be fully filled

        return 1 + countNodes(root.left) + countNodes(root.right);

    }
}

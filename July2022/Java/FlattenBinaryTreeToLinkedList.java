
// @saorav21994
// TC : O(n)
// SC : O(1)

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
    public void flatten(TreeNode root) {
        TreeNode traverse = root;
        while (traverse != null) {
            if (traverse.left != null) {
                TreeNode lefttree = traverse.left;
                while (lefttree.right != null) lefttree = lefttree.right;
                lefttree.right = traverse.right;
                traverse.right = traverse.left;
                traverse.left = null;
            }
            traverse = traverse.right;
        }
        
    }
}

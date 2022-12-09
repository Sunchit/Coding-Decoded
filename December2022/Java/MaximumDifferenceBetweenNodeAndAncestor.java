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
    int result = 0;
    public void find(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }
        int tmp = Math.max(Math.abs(root.val - max), Math.abs(root.val - min));
        result = Math.max(tmp, result);
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        find(root.left, min, max);
        find(root.right, min, max);
        return;
    }
    
    public int maxAncestorDiff(TreeNode root) {
        result = 0;
        if (root == null) {
            return 0;
        }
        find(root, root.val, root.val);
        return result;
    }
}

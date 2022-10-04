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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return dfs(root, targetSum, 0 /*current sum*/);
    }
    
    public boolean dfs(TreeNode node, int targetSum, int csum) {
        if (node == null) {
            if (csum == targetSum)
                return true;
            else 
                return false;
        }
        csum += node.val;
        if (node.left == null && node.right == null) {
            return dfs(null, targetSum, csum);
        }
        else {
            boolean left = false, right = false;
            if (node.left != null) {
                left = dfs(node.left, targetSum, csum);
            }
            if (node.right != null) {
                right = dfs(node.right, targetSum, csum);
            }
            return (left || right);
        }
        
    }
}

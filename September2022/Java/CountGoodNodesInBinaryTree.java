
// @saorav21994
// TC : O(n)
// SC : O(n) -> considering recursion stack space

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
    int res = 0;
    public int goodNodes(TreeNode root) {
        
        dfs(root, root.val);
        return res;
    }
    
    private void dfs(TreeNode node, int max) {
        if (node == null)
            return;
        if (node.val >= max) {
            max = node.val;
            res += 1;
        }
        if (node.left != null)
            dfs(node.left, max);
        if (node.right != null)
            dfs(node.right, max);
        
    }
}

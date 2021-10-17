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
// TC : O(n2)
// SC: O(logn)
class Solution {

    private int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        helper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return ans;
    }

    public void helper(TreeNode root, int sum) {
        if (root == null) return;
        if (sum == root.val) ans++;
        sum = sum-root.val;
        helper(root.left, sum);
        helper(root.right, sum);
    }

}
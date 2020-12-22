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

// TC : O(n) SC: O(logn)
class BalancedBinaryTree {

    private boolean isBalancedTree = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        depth(root);
        return isBalancedTree;

    }

    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        if(Math.abs(leftDepth -rightDepth)>1){
            isBalancedTree =  false;
            return -2;
        }

        return Math.max(leftDepth,rightDepth)+1;

    }
}
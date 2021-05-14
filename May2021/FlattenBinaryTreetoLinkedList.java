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
        if(root==null || (root.left==null && root.right==null)){
            return ;
        }

        preOrderHelper(root);
    }

    // LRI
    private TreeNode preOrderHelper(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode leftChild = preOrderHelper(root.left);
        TreeNode rightChild = preOrderHelper(root.right);

        TreeNode extremeRightOfLC = leftChild;
        while(extremeRightOfLC!=null && extremeRightOfLC.right!=null){
            extremeRightOfLC = extremeRightOfLC.right;
        }

        if(extremeRightOfLC!=null){
            extremeRightOfLC.right = rightChild;
            root.right = leftChild;
        }

        root.left = null;
        return root;
    }
}
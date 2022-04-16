
// @saorav21994
// TC : O(n)
// SC : O(1) -> recursion internal stack
// reverese inorder parse tree and keep on adding prev sum to current node value


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
    
    int sum = 0;
    
    public void reverseInorder(TreeNode root) {
        if (root == null) 
            return;
        reverseInorder(root.right);
        sum += root.val;
        root.val = sum;
        reverseInorder(root.left);
    }
    
    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root);
        return root;
    }
}

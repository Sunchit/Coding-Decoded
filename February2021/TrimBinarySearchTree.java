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
    // TC O(n)
    // SC O(logn), n are the no of nodes in the tree
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) {
            return null;
        } else {
            if(root.val>=low && root.val <=high){
                root.left = trimBST(root.left, low, high);
                root.right = trimBST(root.right, low, high);
            } else if(root.val<low){
                return trimBST(root.right, low, high);
            } else if(root.val>high){
                return trimBST(root.left, low, high);
            }
            return root;
        }
    }
}
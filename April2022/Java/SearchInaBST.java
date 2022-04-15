// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        
        if(root.val==val){
            return root;
        }
        
        TreeNode left=searchBST(root.left,val);
        TreeNode right=searchBST(root.right,val);
        
        if(left!=null)return left;
        return right;
    }
}

// Author: @romitdutta10
// SC: O(1)
// TC: O(log N)
// Problem: https://leetcode.com/problems/search-in-a-binary-search-tree/


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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        
        if(root.val == val) {
            return root;
        } else if(root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}

// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null){
            return null;
        }
        TreeNode l=trimBST(root.left,low,high);
        TreeNode r=trimBST(root.right,low,high);
        if(root.val<low||root.val>high){
            if(l!=null){
                return l;
            }
            return r;
        }
        root.left=l;
        root.right=r;
        return root;
    }
}

// Author: @romitdutta10
// SC: O(log n)
// TC: O(n)
// Problem: https://leetcode.com/problems/trim-a-binary-search-tree/


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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) {
            return null;
        }
        
        if(root.val < low) {
            return trimBST(root.right, low, high);
        }
        
        if(root.val > high) {
            return trimBST(root.left, low, high);
        }
        
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        return root;
    }
}

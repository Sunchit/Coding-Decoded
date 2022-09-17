// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public TreeNode convertBST(TreeNode root) {
       int v=rec(root,0);
        return root;
    }
    
    public int rec(TreeNode root,int add){
        if(root==null){
            return 0;
        }
        int r=rec(root.right,add);
        if(root.right==null){
            root.val+=add;
        }else{
            root.val+=r;
        }
        int l=rec(root.left,root.val);
        if(root.left!=null){
            return l;
        }
        return root.val;
    }
}

// Author: @romitdutta10
// TC: O(n)
// SC: O(log n)
// Problem: https://leetcode.com/problems/convert-bst-to-greater-tree/


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
    public TreeNode convertBST(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        
        convertBST(root.left);
        return root;
        
    }
}


// @saorav21994
// TC : O(n)
// SC : O(n)

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
    public String tree2str(TreeNode root) {
        StringBuffer str = new StringBuffer();
        preorder(root, str);
        return str.toString();
    }
    
    public void preorder(TreeNode root, StringBuffer str) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            str.append(root.val);
            return;
        }
        else if (root.right == null) {
            str.append(root.val);
            str.append("(");
            preorder(root.left, str);
            str.append(")");
            return;
        }
        else {
            str.append(root.val+"(");
            preorder(root.left, str);
            str.append(")(");
            preorder(root.right, str);
            str.append(")");
            return;
        }
    }
}

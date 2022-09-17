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
    private int index  = 0;
    public TreeNode bstFromPreorder(int[] preorder) {

        return bstHelper(preorder, Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
    private TreeNode bstHelper(int[] preorder, int start, int end) {
        if(index >= preorder.length || preorder[index]<start || preorder[index]>end) {
            return null;
        }
        int val = preorder[index];
        index++;
        TreeNode node = new TreeNode(val);
        node.left = bstHelper(preorder, start, val);
        node.right = bstHelper(preorder, val, end);
        return node;
    }
}
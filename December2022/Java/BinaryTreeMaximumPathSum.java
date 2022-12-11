// @saorav21994

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

    /* Max of [ root , root.left + root, root.right + root, root + root.left + root.right ]  */


    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMax(root);

        return res;
    }


    public int findMax(TreeNode root) {
        
        if (root == null)
            return 0;

        int left = findMax(root.left);
        int right = findMax(root.right);    

        int max1 = Math.max(root.val, root.val + Math.max(left, right));
        int max2 = Math.max(max1, root.val+left+right);

        res = Math.max(res, max2);

        return max1;

    }

}

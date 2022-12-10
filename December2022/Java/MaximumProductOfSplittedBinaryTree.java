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
    
    long sum = 0;
    static int mod = 1000000007;
    
    // root node contains the sum of its children's values + itself
    private long findSum(TreeNode root) {
        if (root != null) {
            long left = findSum(root.left);
            long right = findSum(root.right);
            root.val += left + right;
            return root.val;
        }
        return 0L;   // null node
    }
    
    private long findProd(TreeNode root) {
        if (root != null) {
            long left = findProd(root.left);
            long right = findProd(root.right);
            long p = root.val * (sum-(root.val));
            // System.out.println("p = " + p);
            return Math.max(p, Math.max(left,right));
        }
        return 0L;
    }
    
    public int maxProduct(TreeNode root) {
        sum = findSum(root);
        long prod = findProd(root);
        // System.out.println(prod);
        return (int)(prod%mod);
    }
}

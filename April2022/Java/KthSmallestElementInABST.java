
// @saorav21994
// TC : O(n)
// SC : O(1)

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
    
    static int count;
    static int res;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        kthSmallestUtil(root);
        return res;
    }
    
    public void kthSmallestUtil(TreeNode root) {
        if (root == null)
            return;
        
        kthSmallestUtil(root.left);
        
        count -= 1;
        
        // System.out.println(count);
        
        if (count == 0) {
            res = root.val;
            return;
        }
        
        kthSmallestUtil(root.right);
        
        return;
    }
}

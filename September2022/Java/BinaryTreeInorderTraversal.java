
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

// Morris traversal, create threaded binary tree

// morris traversal

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        
        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            }
            else {
                TreeNode cur = root.left;
                while (cur.right != null && cur.right != root) {
                    cur = cur.right;
                }
                
                // 2 cases
                if (cur.right == null) {
                    cur.right = root;
                    root = root.left;
                }
                else {
                    // de-thread it
                    cur.right = null;
                    res.add(root.val);
                    root = root.right;
                }
            }
        }
        
        return res;
        
    }
}

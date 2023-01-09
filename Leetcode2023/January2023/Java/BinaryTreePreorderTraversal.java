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

// Iterative using morris traversal

// TC : O(n)
// SC : O(1)

// Tutorial : https://www.youtube.com/watch?v=80Zug6D1_r4

// Create threaded binary tree -> point the rightmost node of current left subtree to cur, to keep a track of backtracking

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        
        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            }
            else {      // left exists, and we need to make the rightmost node of left point to current node (crate thread)
                TreeNode cur = root.left;
                while (cur.right != null && cur.right != root) {
                    cur = cur.right;
                }       
                // 2 cases
                if (cur.right == null) {  // this is a leaf
                    cur.right = root;
                    // pre-order -> the current processed element is the parent -> so add it
                    res.add(root.val);
                    root = root.left;
                }
                else if (cur.right == root) {     // the left subtree is already processed -> de-thread it and move to right subtree
                    cur.right = null;
                    root = root.right;
                    
                }
            }
        }
        
        return res;
    }
}

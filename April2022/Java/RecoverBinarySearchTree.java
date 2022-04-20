
// @saorav21994
// TC : O(n)
// SC : O(1)

// MICROSOFT, standard GFG questions for tree

// Do inorder traversal and keep track of the 2 nodes which have beeb swapped. They can be within the same subtree or can be in 2 different subtrees.
// At the end check the values and swap them accordingly.



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
    
    TreeNode prev = null, first = null, middle = null, last = null;
    
    public void recoverTree(TreeNode root) {
        
        findFaultNodes(root);
        
        int temp;
        
        if (first != null && last != null) {
            temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if (first != null && middle != null) {
            temp = middle.val;
            middle.val = first.val;
            first.val = temp;
        }
                
    }
    
    public void findFaultNodes(TreeNode root) {
        
        if (root == null)
            return;
        
        // process tree in inorder fashion
        findFaultNodes(root.left);
        
        // for first node
        if (prev == null) {
            prev = root;
        }
        
        else {
            if (root.val < prev.val) {
                if (first == null) {
                    first = prev;
                    middle = root;
                }
                else {
                    last = root;
                }
            }
        
            prev = root;
        }
        
        findFaultNodes(root.right);
        
    }
}

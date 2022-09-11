
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
    public TreeNode pruneTree(TreeNode root) {
        // Do a pre order traversal = Parent->Left->Right
        // In bottom up manner keep of removing nodes if they are/become leaf and has value = 0
        
        if (root == null)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        
        // prune node if its leaf and has value = zero
        if (root.val == 0 && root.left == null && root.right == null) 
            return null;
        
        // else if not leaf or has value 1 return node
        return root;
    }
}

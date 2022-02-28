

// @saorav21994
// TC - O(n)
// SC - O(depth)



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
    
    List<Integer> nodeids = new ArrayList<Integer>();
    
    public int widthOfBinaryTree(TreeNode root) {
        int [] maxWidth = new int[1];
        maxWidth[0] = 1;      // only root exists case
        recursiveBFS(root, 1, maxWidth, 0);
        return maxWidth[0];
    }
    
    public void recursiveBFS(TreeNode root, int curNodeId, int [] maxWidth, int depth) {
        if (root == null)
            return;
        if (depth == nodeids.size())
            nodeids.add(curNodeId);
        else
            maxWidth[0] = Math.max(maxWidth[0], curNodeId-nodeids.get(depth) + 1);
        
        recursiveBFS(root.left, curNodeId*2, maxWidth, depth+1);
        recursiveBFS(root.right, curNodeId*2+1, maxWidth, depth+1);
        
    }
    
}

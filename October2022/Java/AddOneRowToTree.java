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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if (depth == 1) {       // make root of tree as left child of new val node (as stated in question)
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        
        // else bfs traversal till (depth-1) level
        
        depth -= 1;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (depth-- > 1) {
            
            int size = queue.size();
            while (size-- > 0) {
                
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
                
            }
            
        }
        
        while (!queue.isEmpty()) 
        {
            
            TreeNode cur = queue.poll();
            
            TreeNode newNodeLeft = new TreeNode(val);
            newNodeLeft.left = cur.left;
            cur.left = newNodeLeft;
            
            TreeNode newNodeRight = new TreeNode(val);
            newNodeRight.right = cur.right;
            cur.right = newNodeRight;
                        
        }
        
        return root;
        
    }
}

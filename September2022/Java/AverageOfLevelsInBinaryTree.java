
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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> res = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            int csize = size;
            long sum = 0l;
            
            while (csize-- > 0) {
                TreeNode cur = queue.poll();
                sum += (long)cur.val;
                if (cur.left != null)
                     queue.offer(cur.left);
                if (cur.right != null) 
                    queue.offer(cur.right);
            }
            res.add((double)sum/(double)size);
            
        }
        
        return res;
        
        
    }
}


// @saorav21994
// TC : O(n)
// SC : O(n)    -> recursive stack internal
// Can be done with BFS queue -> keep sum of nodes of every level in each loop -> so last level sum will be maintained which will be deepest.


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
    
    int mdepth = Integer.MIN_VALUE, ans = 0;
    
    public void calc(TreeNode node, int depth) {
        if (node == null) return;
        else if (depth > mdepth) {
            mdepth = depth;
            ans = node.val;
        }
        else if (depth == mdepth) {
            ans += node.val;
        }
        calc(node.left, depth+1);
        calc(node.right, depth+1);
    }
    
    public int deepestLeavesSum(TreeNode root) {
        calc(root, 0);
        return ans;
    }
}

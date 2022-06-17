
// @saorav21994 
// TC : O(n)
// SC : O(h)

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
    int res = 0;
    Set<TreeNode> set;
    public int minCameraCover(TreeNode root) {
        set = new HashSet<TreeNode>();
        set.add(null);  // this null is added to handle edge cases
        find(root, null /*psrent*/);
        return res;
    }
    public void find(TreeNode cur, TreeNode par) {
        if (cur != null) {
            // recursively search for all nodes
            find(cur.left, cur);
            find(cur.right, cur);
            if (par == null && !set.contains(cur) /* root node */ || /* either of children has camera */ !set.contains(cur.left) || !set.contains(cur.right)) {
                res += 1;       // add camera here
                set.add(cur);
                set.add(par);
                set.add(cur.left);
                set.add(cur.right);
            }
        }
    }
}

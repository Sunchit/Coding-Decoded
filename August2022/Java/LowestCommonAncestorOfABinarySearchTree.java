
// @saorav21994
// TC : O(n)
// SC : O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashSet<TreeNode> set = new HashSet<>();
        TreeNode tmp = root;
        // add p's ancestors to set
        while (tmp != null) {
            set.add(tmp);
            if (tmp.val == p.val) {
                break;
            }
            else if (tmp.val > p.val) {
                tmp = tmp.left;
            }
            else 
                tmp = tmp.right;
        }
        tmp = root;
        TreeNode res = null;
        // now check for matching of q's ancestors in set
        while (tmp != null) {
            if (set.contains(tmp) == true) {
                res = tmp;
            }
            if (tmp.val == q.val) {
                break;
            }
            else if (tmp.val > q.val) {
                tmp = tmp.left;
            }
            else 
                tmp = tmp.right;
        }
        return res;
    }
}

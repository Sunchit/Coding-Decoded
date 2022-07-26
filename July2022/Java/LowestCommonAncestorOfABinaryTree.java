
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
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        HashSet<TreeNode> ancestors = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        map.put(root, null);    // parent of root is null
        // process all nodes (for all nodes their parent must be knwon in the map)
        while (queue.isEmpty() == false) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                map.put(cur.left, cur);   // node -> parent
                queue.add(cur.left);
            }
            if (cur.right != null) {
                map.put(cur.right, cur);   // node -> parent
                queue.add(cur.right);
            }            
        }
        // System.out.println("all nodes processed");
        while (p != null) {
            // System.out.println("p = " + p.val);
            ancestors.add(p);   // add the ancestors of p in hashset including p itself as it might be the ancestor of q
            p = map.get(p); // get parent of p
        }
        
        // System.out.println("p ancestors added");
        // Iterator it = ancestors.iterator();
        // while (it.hasNext()) {
        //     TreeNode node = it.next();
        //     System.out.println(node.val);
        // }
        while (ancestors.contains(q) == false)  // because ATQ, valid answer will be there or else go with boolean flag
        {   
            // get back ancestor of q and the first one to match will be the LCA
            q = map.get(q);
        }        
        // first match is the lowest common ancestor
        return q;
    }
}

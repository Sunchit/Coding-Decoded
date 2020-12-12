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
class SmallestSubtreewithalltheDeepestNodes {
    // TC : O(n)
    // SC : O(n) , n is no of nodes in the tree
    private Map<TreeNode, Integer> map = new HashMap<>();
    // Used for caching the depth value at each node

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null){
            return null;
        }
        int leftD  = depth(root.left);
        int rightD  = depth(root.right);

        if(leftD == rightD){
            return root;
        } else if(leftD > rightD){
            return subtreeWithAllDeepest(root.left);
        } else if(rightD > leftD){
            return subtreeWithAllDeepest(root.right);
        }
        return null;
    }


    private int depth(TreeNode root){
        if(map.containsKey(root)){
            return map.get(root);
        }
        if(root ==null){
            return 0;
        }
        int leftD = depth(root.left);
        int rightD = depth(root.right);
        int depth = Math.max(leftD, rightD) +1;
        map.put(root, depth);
        return depth;
    }
}
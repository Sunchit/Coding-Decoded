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
class HouseRobberIII {

    Map<TreeNode, Integer> cache = new HashMap<>(); // O(n)

    public int rob(TreeNode root) { // TC O(n), each node is visited once
        if(cache.containsKey(root)){
            return cache.get(root);
        }
        if(root == null){
            return 0;
        } else{
            int leftleftGrandChild  =0 ;
            int rightleftGrandChild  =0 ;

            int leftrightGrandChild  =0 ;
            int rightrightGrandChild  =0 ;

            if(root.left !=null){
                leftleftGrandChild = rob(root.left.left);
                leftrightGrandChild = rob(root.left.right);
            }
            if(root.right !=null){
                rightleftGrandChild = rob(root.right.left);
                rightrightGrandChild = rob(root.right.right);
            }

            int includingRoot = root.val + leftleftGrandChild + rightleftGrandChild + leftrightGrandChild + rightrightGrandChild;

            int leftChild = rob(root.left);
            int rightChild = rob(root.right);

            int excludingRoot = leftChild + rightChild;

            cache.put(root,  Math.max(includingRoot, excludingRoot));
            return cache.get(root);


        }
    }
}
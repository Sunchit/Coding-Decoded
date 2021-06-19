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
class SumOfLeftLeaves {
    private int totalSum =0;
    public int sumOfLeftLeaves(TreeNode root) {
        preorderTravserval(root, false);
        return totalSum;
    }

    // boolean for keeping track of whether the current node is left child or right child
    private void preorderTravserval(TreeNode root, boolean isLeftChild){
        if(root==null){
            return ;
        }

        if(isLeaf(root) && isLeftChild){
            totalSum += root.val;
        }


        preorderTravserval(root.left, true);
        preorderTravserval(root.right, false);

    }
    // function to identify the leaf node
    private boolean isLeaf(TreeNode root){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right ==null){
            return true;
        } else{
            return false;
        }

    }

}
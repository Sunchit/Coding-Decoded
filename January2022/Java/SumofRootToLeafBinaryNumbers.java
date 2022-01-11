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

class SumofRootToLeafBinaryNumbers {
    int totalSum = 0;
    public int sumRootToLeaf(TreeNode root) {
        if(root==null){
            return 0;
        }

        postOrderTraversal(root, 0);
        return totalSum;
    }
    // O(n), where n is the no of nodes in the tree
    private void postOrderTraversal(TreeNode root, int currVal){
        if(root==null){
            return ;
        }
        currVal = currVal + root.val;

        // leaf node or not
        if(root.left == null && root.right==null){
            totalSum += currVal;
            return ;
        }
        postOrderTraversal(root.left , currVal* 2);
        postOrderTraversal(root.right , currVal* 2);

    }
}
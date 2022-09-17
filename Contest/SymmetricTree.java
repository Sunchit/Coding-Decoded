// https://leetcode.com/problems/symmetric-tree/
// @author: anuj0503
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;
        
        return isSymmetricUtil(root.left, root.right);
    }
    
    private boolean isSymmetricUtil(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        
        if(root1 != null && root2 != null && root1.val == root2.val){
            return isSymmetricUtil(root1.left, root2.right) && isSymmetricUtil(root1.right, root2.left);
        }
        
        return false;
    }
}

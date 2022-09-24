// https://leetcode.com/problems/path-sum/
// @author: anuj0503
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        
        return hasPathSum(root, targetSum, root.val);
    }
    
    private boolean hasPathSum(TreeNode root, int targetSum, int currSum){
        if(root == null) return false;
        
        if(root.left == null && root.right == null){
            if(currSum == targetSum) return true;
            
            return false;
        }
        
        boolean ans = false;
        if(root.left != null)
            ans |=  hasPathSum(root.left, targetSum, currSum + root.left.val);
        
        if(root.right != null)
            ans |= hasPathSum(root.right, targetSum, currSum + root.right.val);
        
        return ans;
    }
}

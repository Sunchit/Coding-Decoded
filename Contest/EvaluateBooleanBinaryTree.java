// https://leetcode.com/problems/evaluate-boolean-binary-tree/
// @author: @anuj0503
class Solution {
    public boolean evaluateTree(TreeNode root) {
        if(root.left == null && root.right == null)
            return (root.val == 1)?true:false;
        
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        
        if(root.val == 2)
            return left || right;
        
        return left && right;
    }

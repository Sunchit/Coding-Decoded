// https://leetcode.com/problems/binary-tree-inorder-traversal/
// @author: anuj0503
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();
        
        while(curr!= null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            
            TreeNode top = stack.pop();
            result.add(top.val);
            
            if(top.right != null)
                curr = top.right;
        }
        
        return result;
    }
}

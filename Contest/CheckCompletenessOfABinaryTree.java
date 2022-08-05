// https://leetcode.com/problems/check-completeness-of-a-binary-tree/
// @author: anuj0503
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null || (root.right == null && root.left == null))
            return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-->0){
                TreeNode head = queue.poll();
                
                if(head == null){
                    while(!queue.isEmpty()){
                        TreeNode node = queue.poll();
                        
                        if(node != null) return false;
                    }
                    
                    return true;
                }
                
                queue.offer(head.left);
                queue.offer(head.right);
            }
        }
        
        return true;
    }
}

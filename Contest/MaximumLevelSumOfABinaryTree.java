// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
// @author: anuj0503
class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root.left == null && root.right == null) return 1;

        int maxSum = Integer.MIN_VALUE;
        int result = 0, level = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            int sum = 0;
            
            while (size-->0) {
                TreeNode head = queue.poll();
                sum += head.val;
                
                if (head.left != null) queue.offer(head.left);
                if (head.right != null) queue.offer(head.right);
            }
            
            if(sum > maxSum){
                result = level;
                maxSum = sum;
            }
        }
        
        return result;
    }
}

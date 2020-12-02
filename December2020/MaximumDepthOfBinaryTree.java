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
// TC is O(n) since each node is traversed once
class MaximumDepthOfBinaryTree {

    // DFS
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    //BFS
    public int maxDepth(TreeNode root) {


        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        int level =0;
        while(!qu.isEmpty()){
            int size = qu.size();
            level++;
            while(size-->0){
                TreeNode head = qu.poll();
                if(head.left !=null){
                    qu.offer(head.left);
                }
                if(head.right !=null){
                    qu.offer(head.right);
                }

            }

        }
        return level;
    }
}
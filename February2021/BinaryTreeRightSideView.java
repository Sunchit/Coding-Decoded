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
class Solution {
    // TC : O(n)
    // SC : O(level with most of elements)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rsvList = new ArrayList<>();
        if(root == null){
            return rsvList;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            int quSize = qu.size();
            while(size>0){
                TreeNode head = qu.poll();
                if(size == quSize){
                    rsvList.add(head.val);
                }

                if(head.right!=null){
                    qu.offer(head.right);
                }


                if(head.left!=null){
                    qu.offer(head.left);
                }
                size--;
            }

        }
        return rsvList;
    }
}
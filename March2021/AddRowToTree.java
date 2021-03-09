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
    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if(d == 1){
            TreeNode newNode = new TreeNode(v);
            newNode.left = root;
            return newNode;
        }

        Queue<TreeNode> qu = new LinkedList<>();
        d = d-1;
        qu.offer(root);
        int level = 1;
        while(level != d){
            int size = qu.size();
            level++;
            while(size-->0){
                TreeNode head =qu.poll();
                if(head.left!=null){
                    qu.offer(head.left);
                }
                if(head.right!=null){
                    qu.offer(head.right);
                }
            }
        }

        while(!qu.isEmpty()){
            TreeNode head = qu.poll();
            TreeNode leftChild = head.left;
            TreeNode rightChild = head.right;

            TreeNode newLeft = new TreeNode(v);
            TreeNode newRight = new TreeNode(v);

            head.left = newLeft;
            head.right = newRight;

            newLeft.left = leftChild;
            newRight.right = rightChild;
        }

        return root;
    }
}
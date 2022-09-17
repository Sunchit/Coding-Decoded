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

// Solution I : DFS
class Solution {
    private int xDepth = -1;
    private int yDepth = -2;

    private TreeNode xParent = null;
    private TreeNode yParent = null;


    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return true;
        }

        isCousinsHelper(root, x, y, 0,  null);
        return xDepth==yDepth && xParent !=yParent;
    }

    private  void isCousinsHelper(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null){
            return ;
        }
        else if(root.val == x){
            xParent = parent;
            xDepth = depth;
        } else if(root.val == y){
            yParent = parent;
            yDepth = depth;
        } else {
            isCousinsHelper(root.left, x, y, depth+1, root);
            isCousinsHelper(root.right, x, y, depth+1, root);
        }
    }
}


// Solution II BFS
class Solution {
    	public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode xParent = null, yParent = null;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode head = queue.poll();
                if(head.left != null){
                    queue.offer(head.left);
                    if(head.left.val == x){
                        xParent = head;
                    }
                    if(head.left.val == y){
                        yParent = head;
                    }
                }
                if(head.right != null){
                    queue.offer(head.right);
                     if(head.right.val == x){
                        xParent = head;
                    }
                    if(head.right.val == y){
                        yParent = head;
                    }
                }
                if(xParent!=null &&yParent!=null){
                    return xParent != yParent; // equality means not cousins
                    // non equality means cousins
                }
            }

            if((xParent==null && yParent!=null) || (xParent!=null &&yParent==null)){
                return false;
            }


        }
        return false;
    }
}

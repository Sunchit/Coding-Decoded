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
class DeleteANodeInBst {
    // Searching a node in tree + Inorder Successor in Binary Search Tree
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root; // return null
        }

        if(root.val <key){
            root.right = deleteNode(root.right, key);
            return root;
        } else if(root.val>key){
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            // root.val == key
            // leaf node
            if(root.left == null && root.right ==null){
                return null;
            }
            if(root.left ==null){
                return root.right; // left child is null
            } else if(root.right == null){
                return root.left; // right child is null
            } else {
                // left child is not null and right child is not null
                TreeNode nextMinNode = root.right;
                while(nextMinNode.left !=null){
                    nextMinNode = nextMinNode.left;
                }

                nextMinNode.left = root.left;
                return root.right;
            }
        }
    }
}
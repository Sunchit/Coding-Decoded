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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // Do inorder of both trees and store them in 2 lists. Then merge 2 sorted lists.
        // Inorder traversal of BST will give sorted list.
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();
        inorder(root1, tree1);
        inorder(root2, tree2);
        
        List<Integer> res = new ArrayList<>();
        merge(tree1, tree2, res);
        return res;
    }
    
    private void inorder(TreeNode root, List<Integer> tree) {
        if (root == null)
            return;
        inorder(root.left, tree);
        tree.add(root.val);
        inorder(root.right, tree);
    }
    
    private void merge(List<Integer> tree1, List<Integer> tree2, List<Integer> res) {
        int l1 = tree1.size();
        int l2 = tree2.size();
        
        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            if (tree1.get(i) <= tree2.get(j)) {
                res.add(tree1.get(i));
                i += 1;
            }
            else {
                res.add(tree2.get(j));
                j += 1;
            }
            
        }
        while (i < l1) {
            res.add(tree1.get(i));
            i += 1;
        }
        while (j < l2) {
            res.add(tree2.get(j));
            j += 1;
        }
        
    }
}

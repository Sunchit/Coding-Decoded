
// @saorav21994
// TC : O(n)
// SC : O(n)

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
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    int preCtr = 0;
    public TreeNode computeTree(int [] preorder, int [] inorder, int start, int end) {
        if (start > end) 
            return null;   // no node exits
        TreeNode node = new TreeNode(preorder[preCtr]);
        preCtr += 1;
        if (start == end)
            return node;  // only sole node
        
        // search index of the node in hashMap
        int i = indexMap.get(node.val);
        node.left = computeTree(preorder, inorder, start, i-1);
        node.right = computeTree(preorder, inorder, i+1, end);
        
        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = computeTree(preorder, inorder, 0, preorder.length-1);
        return root;
    }
}

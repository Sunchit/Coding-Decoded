
// @saorav21994

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
    ArrayList<Integer> al = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        al = new ArrayList<>();
        inorder(root);
        Integer [] arr = al.toArray(new Integer[0]);
        int n = arr.length;
        int l = 0, r = n-1;
        while (l < r) {
            if (arr[l]+arr[r] == k)
                return true;
            else if (arr[l]+arr[r] < k)
                l++;
            else  
                r--;
        }
        return false;
        
    }
    
    private void inorder(TreeNode root) {
        if (root == null) 
            return;
        if (root.left != null)
            inorder(root.left);
        al.add(root.val);
        if (root.right != null)
            inorder(root.right);
        
    }
}

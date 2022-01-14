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

// TC: O(logn) -> O(n)
// SC: O(logn)
class Solution {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root==null){
			return new TreeNode(val);
		} else if(root.val > val){
			root.left = insertIntoBST(root.left, val);
		} else{
			root.right = insertIntoBST(root.right, val);
		}
		return root;
	}
}


 class Solution {
     public TreeNode insertIntoBST(TreeNode root, int val) {
         if(root == null)
             return new TreeNode(val);

         TreeNode tmp = root;
         while(true){
             //go to right sub tree
             if(tmp.val < val){
                 if(tmp.right == null){
                     tmp.right = new TreeNode(val);
                     break;
                 }else{
                     tmp = tmp.right;
                 }
             }
             //go to left sub tree
             else{
                 if(tmp.left == null){
                     tmp.left = new TreeNode(val);
                     break;
                 }else{
                     tmp = tmp.left;
                 }
             }
         }
         return root;
     }
 }
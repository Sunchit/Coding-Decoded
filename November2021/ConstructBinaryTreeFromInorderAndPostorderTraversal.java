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
// TC : O(n)
// SC : O(n)
class Solution {
  private int pos =0;
  public TreeNode buildTree(int[] inorder, int[] postorder) {

    pos = postorder.length-1;

    Map<Integer, Integer> map = new HashMap<Integer,Integer>();
    for (int i=0;i<inorder.length;++i) {
      map.put(inorder[i], i);
    }

    TreeNode root = constructTree(inorder, postorder,  0, inorder.length-1, map );
    return root;
  }

  private TreeNode constructTree(int[] inorder, int[] postorder, int startIn, int endIn, Map<Integer, Integer> map){
    if(pos<0 || startIn> endIn){
      return null;
    }


    int val = postorder[pos];

    TreeNode node = new TreeNode(val);
    pos--;

    // indentify the position in the inorder tree
    int i= map.get(val);
    TreeNode right = constructTree(inorder, postorder, i+1, endIn, map);

    TreeNode left = constructTree(inorder, postorder, startIn, i-1, map);


    node.right = right;
    node.left = left;
    return node;
  }
}
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
// SC : O(logn)
class Solution {
    int i = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> toBeSwappedN = new ArrayList<>();

        if(dfs(root, voyage, toBeSwappedN)){
            return toBeSwappedN;
        } else{
            List<Integer> rejectCase =new ArrayList<>();
            rejectCase.add(-1);
            return rejectCase;
        }
    }

    private boolean dfs(TreeNode root, int[] voyage, List<Integer> toBeSwappedN){
        if(root == null){
            return true;
        }
        if(root.val != voyage[i]){
            return false;
        } else {
            i++;
        }

        if(root.left!=null && root.left.val != voyage[i]){
            toBeSwappedN.add(root.val);
            return  dfs(root.right, voyage, toBeSwappedN) && dfs(root.left, voyage, toBeSwappedN);

        } else{
            return  dfs(root.left, voyage, toBeSwappedN) && dfs(root.right, voyage, toBeSwappedN);
        }


    }
}
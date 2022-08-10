
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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = convertBalancedBST(nums, 0, nums.length-1);
        return root;
    }
    public TreeNode convertBalancedBST(int [] nums, int start, int end) {
       if(start>end)
            return null;
        int mid = (start+end+1)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = convertBalancedBST(nums, start, mid-1);
        node.right = convertBalancedBST(nums, mid+1, end);
        return node;
    }
}

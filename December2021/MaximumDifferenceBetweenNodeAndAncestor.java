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
	private int maxDiff = 0;
	public int maxAncestorDiff(TreeNode root) {
		if(root == null){
			return maxDiff;
		}
		maxDiffHelper(root);
		return maxDiff;
	}

	// { max, min}
	private int[] maxDiffHelper(TreeNode root){
		if(root == null){
			return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
		}

		int[] left = maxDiffHelper (root.left);

		int[] right = maxDiffHelper (root.right);
		int leftMin = left[0];
		int rightMin = right[0];
		int min = Math.min(root.val, Math.min(leftMin, rightMin));


		int leftMax = left[1];
		int rightMax = right[1];
		int max = Math.max(root.val, Math.max(leftMax, rightMax));

		maxDiff = Math.max((max - root.val), Math.max((root.val- min), maxDiff));
		return new int[]{min, max};

	}
}
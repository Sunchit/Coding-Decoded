// TC : O(n)
// SC : O(logn)
public class Solution {
	private int result = 0;

	public int findTilt(TreeNode root) {
		postOrder(root);
		return result;
	}

	private int postOrder(TreeNode root) {
		if (root == null) return 0;

		int leftSubstreeSum = postOrder(root.left);
		int rightSubstreeSum = postOrder(root.right);

		result += Math.abs(leftSubstreeSum - rightSubstreeSum);

		return leftSubstreeSum + rightSubstreeSum + root.val;
	}
}
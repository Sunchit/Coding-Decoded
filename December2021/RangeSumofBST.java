// TC : O(n)
// SC : O(logn)
class Solution {
	private int sum = 0;
	public int rangeSumBST(TreeNode root, int L, int R) {
		rangeSumBSTHelper(root, L, R);
		return sum;
	}
	private void rangeSumBSTHelper(TreeNode root, int L, int R){
		if(root==null){
			return ;
		}

		if(root.val>=L && root.val<=R){
			sum+=root.val;
			rangeSumBSTHelper(root.left, L, root.val);
			rangeSumBSTHelper(root.right, root.val, R);

		} else if(root.val<L){
			rangeSumBSTHelper(root.right, L, R);
		} else if(root.val>R){
			rangeSumBSTHelper(root.left, L, R);
		}

	}
}
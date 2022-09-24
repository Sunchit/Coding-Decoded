/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

 */

// TC : O(n)
class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<>();


		dfs(root, 0, ans, new ArrayList<>(), sum);

		return ans;

	}

	private void dfs(TreeNode root, int runningSum, List<List<Integer>> ans, List<Integer> runningList, int target){
		if(root==null){
			return ;
		}
		int totalCurrSum = root.val+ runningSum;

		runningList.add(root.val);

		if(root.left==null && root.right==null && target == totalCurrSum){
			// terminal node
			ans.add(new ArrayList<Integer>(runningList));
			return;
		}
		// pre order traversal

		dfs(root.right, totalCurrSum, ans, new ArrayList<>(runningList), target);
		dfs(root.left, totalCurrSum, ans, new ArrayList<>(runningList), target);

	}
}
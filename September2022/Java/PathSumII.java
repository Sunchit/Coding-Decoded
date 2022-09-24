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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, res, new ArrayList<Integer>());
        return res;
    }
    
    private void dfs(TreeNode root, int target, List<List<Integer>> res, List<Integer> cur) {
        if (root == null) 
            return;
        if (root.left == null && root.right == null && root.val == target) {
            cur.add(root.val);
            res.add(cur);
            return;
        }
        cur.add(root.val);
        dfs(root.left, target-root.val, res, new ArrayList<>(cur));
        dfs(root.right, target-root.val, res, new ArrayList<>(cur));
    }
}

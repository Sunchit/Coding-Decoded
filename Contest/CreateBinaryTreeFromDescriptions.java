
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
	public TreeNode createBinaryTree(int[][] descriptions) {
		Map<Integer, TreeNode> map = new HashMap<>();
		Set<Integer> childrenSet = new HashSet<>();
		for (int[] arr : descriptions) {
			int parentInt = arr[0];
			int childInt = arr[1];
			int isLeft = arr[2];

			childrenSet.add(childInt);

			TreeNode parentNode = map.getOrDefault(parentInt, new TreeNode(parentInt));

			if (isLeft == 1) {
				parentNode.left = map.getOrDefault(childInt, new TreeNode(childInt));
				map.put(childInt, parentNode.left);
			} else {
				parentNode.right = map.getOrDefault(childInt, new TreeNode(childInt));
				map.put(childInt, parentNode.right);
			}
			map.put(parentInt, parentNode);
		}

		int root = -1;

		for (int [] arr: descriptions) {
			if (!childrenSet.contains(arr[0])) {
				root = arr[0];
				break;
			}
		}

		return map.getOrDefault(root, null);
	}
}
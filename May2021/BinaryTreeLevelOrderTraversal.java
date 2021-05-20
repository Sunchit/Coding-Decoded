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

    // BFS traversal
     public List<List<Integer>> levelOrder(TreeNode root) {
     	List<List<Integer>> res = new ArrayList<>();
     	if (root == null)
     		return res;
     	Queue<TreeNode> q = new LinkedList<>();
     	q.add(root);
     	while(!q.isEmpty()) {
     		int size = q.size();
     		List<Integer> currLevel = new ArrayList<>();
     		while(size-->0) {
     			TreeNode currNode = q.poll();
     			currLevel.add(currNode.val);
     			if (currNode.left != null)
     				q.add(currNode.left);
     			if (currNode.right != null)
     				q.add(currNode.right);
     		}
     		res.add(currLevel);
     	}
     	return res;
     }

    // DFS Solution

    // TC: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height == res.size()) {
            res.add(new ArrayList<Integer>()); // new level creation
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }

}
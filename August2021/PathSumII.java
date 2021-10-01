class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(root, targetSum, 0, res, new ArrayList<Integer>());
        return res;
    }
    
    private void backtrack(TreeNode node, int targetSum, int currSum, List<List<Integer>> res, List<Integer> path) {
        if (node == null) return;
        currSum += node.val;
        path.add(node.val);
        if (node.left == null && node.right == null && targetSum == currSum) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(path);
            res.add(temp);
        }
        backtrack(node.left, targetSum, currSum, res, path);
        backtrack(node.right, targetSum, currSum, res, path);
        currSum -= node.val;
        path.remove(path.size() - 1);
    }
}

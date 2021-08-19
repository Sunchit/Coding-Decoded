class Solution {
    private long totalSum = 0 ;
    private long maxProd = 0;

    public int maxProduct(TreeNode root) {
        dfs(root);
        calculateSubTreeSum(root);
        return (int)(maxProd % ((int)Math.pow(10, 9) + 7));
    }

    public  void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        dfs(root.right);

        totalSum += (long)root.val;
    }
    public  long calculateSubTreeSum(TreeNode root) {
        if(root == null) return 0;
        long l = calculateSubTreeSum(root.left);
        long r = calculateSubTreeSum(root.right);
        long subTreeSum = l + r + root.val;
        maxProd = Math.max(maxProd, (subTreeSum) * (totalSum - subTreeSum));
        return subTreeSum;
    }

}

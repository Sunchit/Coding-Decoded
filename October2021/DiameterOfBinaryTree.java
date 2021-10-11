class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int curDiameter = maxDepthOfTree(root.left) + maxDepthOfTree(root.right);

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(curDiameter, Math.max(rightDiameter, leftDiameter));
    }

    public int maxDepthOfTree(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(maxDepthOfTree(root.left), maxDepthOfTree(root.right));
    }
}
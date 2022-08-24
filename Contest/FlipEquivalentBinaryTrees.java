// https://leetcode.com/problems/flip-equivalent-binary-trees/
// @author: anuj0503
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        makingTreeBST(root1);
        makingTreeBST(root2);

        return isTreeSame(root1, root2);
    }

    private void makingTreeBST(TreeNode root){
        if(root == null) return;

        if(root.right == null && root.left == null) return;

        if(root.right == null){
            if(root.left.val > root.val){
                root.right = root.left;
                root.left = null;
                makingTreeBST(root.right);
            } else {
                makingTreeBST(root.left);
            }
            
            return;
        }

        if(root.left == null){
            if(root.right.val < root.val){
                root.left = root.right;
                root.right = null;
                makingTreeBST(root.left);
            } else {
                makingTreeBST(root.right);
            }
            return;
        }

        int left = root.left.val;
        int right = root.right.val;

        if(left > right){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        makingTreeBST(root.left);
        makingTreeBST(root.right);

    }

    private boolean isTreeSame(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;

        if(root1 == null || root2 == null) return false;

        if(root1.val == root2.val){
            return isTreeSame(root1.left, root2.left) && isTreeSame(root1.right, root2.right);
        }

        return false;
    }
}

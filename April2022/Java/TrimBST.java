// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null){
            return null;
        }
        TreeNode l=trimBST(root.left,low,high);
        TreeNode r=trimBST(root.right,low,high);
        if(root.val<low||root.val>high){
            if(l!=null){
                return l;
            }
            return r;
        }
        root.left=l;
        root.right=r;
        return root;
    }
}
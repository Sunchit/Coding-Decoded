// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public TreeNode convertBST(TreeNode root) {
       int v=rec(root,0);
        return root;
    }
    
    public int rec(TreeNode root,int add){
        if(root==null){
            return 0;
        }
        int r=rec(root.right,add);
        if(root.right==null){
            root.val+=add;
        }else{
            root.val+=r;
        }
        int l=rec(root.left,root.val);
        if(root.left!=null){
            return l;
        }
        return root.val;
    }
}
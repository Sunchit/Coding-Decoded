// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int m;
    public int kthSmallest(TreeNode root, int k) {
        m=k;
        return ans(root);
    }
    public int ans(TreeNode root){
        if(root.left!=null){
         int l=ans(root.left);
            if(m==0){
                return l;
            }
        }
        m--;
        if(m==0){
            return root.val;
        }
        if(root.right!=null){
         int r=ans(root.right);
            if(m==0)return r;
        }
        
        return 0;
    }
}
// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun searchBST(root: TreeNode?, x: Int): TreeNode? {
        if(root==null){
            return null;
        }
        
        if(root.`val`== x){
            return root;
        }
        
        var left:TreeNode?=searchBST(root.left,x);
        var right:TreeNode?=searchBST(root.right,x);
        
        if(left!=null)return left;
        return right;
    }
}
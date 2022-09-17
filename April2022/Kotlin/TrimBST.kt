// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? {
        if(root==null){
            return null;
        }
        var l:TreeNode?=trimBST(root.left,low,high);
        var r:TreeNode?=trimBST(root.right,low,high);
        if(root.`val`<low||root.`val`>high){
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
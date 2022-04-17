// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun convertBST(root: TreeNode?): TreeNode? {
        rec(root,0)
        return root
    }
    
    fun rec(root:TreeNode?,add:Int):Int{
        if(root==null){
            return 0
        }
        var r=rec(root.right,add)
        if(root.right==null){
            root.`val`+=add
        }else{
            root.`val`+=r
        }
        var l=rec(root.left,root.`val`)
        if(root.left!=null){
            return l
        }
        return root.`val`
    }
    
}
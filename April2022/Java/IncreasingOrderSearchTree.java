// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<TreeNode> al=new ArrayList<>();
        rec(root,al);
        for(int i=al.size()-1;i>=0;i--){
            al.get(i).left=null;
            al.get(i).right=null;
            if(i<al.size()-1){
                al.get(i).right=al.get(i+1);
            }
        }
        return al.get(0);
    }
    public void rec(TreeNode root, ArrayList<TreeNode> al){
        if(root==null){
            return;
        }
        rec(root.left,al);
        al.add(root);
        rec(root.right,al);
    }
}
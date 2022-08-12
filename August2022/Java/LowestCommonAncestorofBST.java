/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> al=get(root,p);
        ArrayList<TreeNode> ab=get(root,q);
        Collections.reverse(al);
        Collections.reverse(ab);
        for(int i=0;i<al.size()&&i<ab.size();i++){
            if(al.get(i).val!=ab.get(i).val){
                return al.get(i-1);
            }
        }
       return al.get(Math.min(al.size()-1,ab.size()-1));
    }
    
    public ArrayList<TreeNode> get(TreeNode p,TreeNode x){
        if(p==null)return new ArrayList<>();
        if(p.val==x.val){
            ArrayList<TreeNode> al=new ArrayList<>();
            al.add(x);
            return al;
        }
        
        ArrayList<TreeNode> l=get(p.left,x);
        ArrayList<TreeNode> r=get(p.right,x);
        if(l.size()>0){
            l.add(p);
            return l;
        }
        
        if(r.size()>0){
            r.add(p);
            return r;
        }
        
        return new ArrayList<>();
       
    }
}
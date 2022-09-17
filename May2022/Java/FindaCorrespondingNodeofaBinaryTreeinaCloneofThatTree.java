// Author: Shobhit Behl (LC: shobhitbruh)/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        ArrayList<Character> al=new ArrayList<>();
        ArrayList<Character> a=dfs(original,target,al);
        int i=0;
        TreeNode n=cloned;
        while(i<a.size()){
            if(a.get(i)=='L'){
                n=n.left;
            }else{
                n=n.right;
            }
            i++;
        }
        return n;
    }
    
    public ArrayList<Character> dfs(TreeNode node,TreeNode t,ArrayList<Character> al){
        if(node==null){
            return new ArrayList<>();
        }
        if(node==t){
            return new ArrayList<>(al);
        }
        al.add('L');
        ArrayList<Character> l=dfs(node.left,t,al);
        al.remove(al.size()-1);
        al.add('R');
        ArrayList<Character> r=dfs(node.right,t,al);
        al.remove(al.size()-1);
        if(l.size()>0){
            return l;
        }
        return r;
    }
}
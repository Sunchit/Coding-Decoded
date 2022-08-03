// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
// @author: anuj0503
class Solution {
    String startString;
    String destString;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode parent = LCA(root, startValue, destValue);
        startString = "";
        destString = "";
        
        StringBuilder sb = new StringBuilder();
        
        // Finding path from LCA to source and LCA to destination.
        search(parent, startValue, destValue, sb);

        // Since from source we always have to come to LCA to go for destination.
        // replacing all path charcter to source to 'U' (up).
        startString = startString.replace('L', 'U');
        startString = startString.replace('R', 'U');
        
        return startString + destString;
    }
    
    private void search(TreeNode root, int startValue, int destValue, StringBuilder sb){        
        if(root.val == startValue){
            startString = new String(sb.toString());
        }
        
        if(root.val == destValue){
            destString = new String(sb.toString());
        }
        
        if(root.left != null){
            sb.append("L");
            
            search(root.left, startValue, destValue, sb);
            
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(root.right!= null){
            sb.append("R");
            
            search(root.right, startValue, destValue, sb);
            
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    // Finding Lowest Common Ancestor
    private TreeNode LCA(TreeNode root, int p, int q){
        if(root == null) return null;
        
        if(root.val == p || root.val == q){
            return root;
        }
        
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        
        if(left != null && right != null) return root;
        
        if(left != null) return left;
        
        return right;
    }
}

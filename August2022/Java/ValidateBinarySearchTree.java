
// @saorav21994

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean check(TreeNode root, TreeNode left, TreeNode right) {
        
        if (root == null) 
            return true; 

        if (left != null && root.val <= left.val) 
            return false; 

        if (right != null && root.val >= right.val) 
            return false; 

        return check(root.left, left, root) && 
               check(root.right, root, right); 
    }
    
    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }
}
// shobhitbruh
// naive approach
class Solution {
    public boolean isValidBST(TreeNode root) {
        al = new ArrayList<>();
        rec(root);

        for (int i = 1; i < al.size(); i++) {
            if (al.get(i) <= al.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public void rec(TreeNode x) {
        if (x == null)
            return;
        rec(x.left);
        al.add(x.val);
        rec(x.right);
    }

    public ArrayList<Integer> al;
}

// Inorder Morris Traversal
class Solution {
    public TreeNode getright(TreeNode x, TreeNode curr) {
        while (x.right != null && x != curr) {
            x = x.right;
        }

        return x;
    }

    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        TreeNode l = null;
        TreeNode prev = null;
        while (curr != null) {
            if (curr.left != null) {
                l = curr.left;
                TreeNode r = getright(l, curr);
                if (r == curr) {
                    l.right = null;
                    if (prev.val >= curr.val) {
                        return false;
                    }
                    prev = curr;
                    curr = curr.right;
                } else {
                    r.right = curr;
                    curr = curr.left;
                }
            } else {
                if (prev != null && prev.val >= curr.val) {
                    return false;
                }
                prev = curr;
                curr = curr.right;
            }
        }

        return true;
    }
}

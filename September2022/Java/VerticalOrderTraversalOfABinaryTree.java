
// @saorav21994
// TC : O(n + #verticalLevels*hlogh) -> because for each vertical level, max height of tree = h = (log n) and we need to sort that.
// SC : O(n) -> we are maintaining each node in appropriate vertical list


// Note : for question in which order of output is as per nodes in original tree and not sorted -> use level order traversal+hashmap as solution

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
    
    class LLNode {
        List<int[]> list;
        LLNode prev, next;
        
        public LLNode(int val, int level) {
            this.list = new ArrayList<>();
            this.list.add(new int[] {val, level});
            this.prev = null;
            this.next = null;
        }
        
        public void add(int val, int level) {
            this.list.add(new int[] {val, level});
        }
        
        
    }
    
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        int level = 0;
        LLNode llroot = new LLNode(root.val, level);
        traverse(root.left, llroot, -1, level+1);
        traverse(root.right, llroot, 1, level+1);
        
        while (llroot.prev != null) {
            llroot = llroot.prev;
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        while (llroot != null) {
            List<Integer> subRes = new ArrayList<>();
            
            
            // [0] = value, [1] = level
            Collections.sort(llroot.list, (a, b) -> ((a[1] == b[1]) ? (a[0] - b[0]) : (a[1] - b[1])));
            
            for (int [] value : llroot.list) {
                subRes.add(value[0]);
            }
            res.add(new ArrayList<>(subRes));
            llroot = llroot.next;
        }
        
        return res;
        
    }
    
    public void traverse(TreeNode node, LLNode lnode, int side, int level) {
        
        if (node == null)
            return;
        
        if (side == -1) {       // left
            if (lnode.prev == null) {
                lnode.prev = new LLNode(node.val, level);
                lnode.prev.next = lnode;
                lnode = lnode.prev;
            }
            else {      // prev node exists already
                lnode = lnode.prev;
                lnode.add(node.val, level);
            }
            
        }
        else if (side == 1) {       // right
            if (lnode.next == null) {
                lnode.next = new LLNode(node.val, level);
                lnode.next.prev = lnode;
                lnode = lnode.next;
            }
            else {      // next node exists already
                lnode = lnode.next;
                lnode.add(node.val, level);
            }
            
        }
        
        
        if (node.left != null) {
            traverse(node.left, lnode, -1, level+1);
        }
        
        if (node.right != null) {
            traverse(node.right, lnode, 1, level+1);
        }
        
        return;
        
    }
    
}

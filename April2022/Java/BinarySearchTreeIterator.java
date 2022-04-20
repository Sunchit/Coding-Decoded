
// @saorav21994
// TC : O(1) average
// SC : O(h)


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
class BSTIterator {
    
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        // initialize root to a non-existent smaller number than any element in the BST
        root = new TreeNode(stack.peek().val-1);
    }
    
    public int next() {
        
        if (stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        
        TreeNode top = stack.pop();
        int res = top.val;
        
        top = top.right;
        
        while (top != null) {
            stack.push(top);
            top = top.left;
        }
        
        return res;
    }
    
    public boolean hasNext() {
        // System.out.println(stack.peek().val);
        return !stack.isEmpty();
    }
}


public class BSTIterator {

	Stack<TreeNode> stack =  null ;
	TreeNode current = null ;

	public BSTIterator(TreeNode root) {
		current = root;
		stack = new Stack<> ();
	}

	public boolean hasNext() {
		return !stack.isEmpty() || current != null;
	}

	public int next() {
		while (current != null) {
			stack.push(current);
			current = current.left ;
		}
		TreeNode t = stack.pop() ;
		current = t.right ;
		return t.val ;
	}
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

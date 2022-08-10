// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
// @author: anuj0503

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return binarySearchTree(null, head);
    }
    
    private TreeNode binarySearchTree(ListNode last, ListNode head){
        if(last == head || head == null){
            return null;
        }
        
        if(last == head.next){
            return new TreeNode(head.val);
        }
        
        // System.out.println(last + " " + head.val);
        ListNode fast = head, slow = head;
        while(fast != last && fast.next != last){
            // System.out.println(fast.val);
            fast = fast.next.next;
            slow = slow.next;
        }
        
        TreeNode node = new TreeNode(slow.val);
        node.left = binarySearchTree(slow, head);
        node.right = binarySearchTree(last, slow.next);
        
        return node;
    }
}

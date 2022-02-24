

// @saorav21994
// Use merge sort. Find the middle element and recursively partition to get each node. Finally merge/combine them together.

// TC : O(nlogn)
// SC : recursion -> internal stack used


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    // merge
    public ListNode combine(ListNode left, ListNode right) {
        
        if (left == null) return right;
        if (right == null) return left;
        
        ListNode head = null;
        
        if (left.val <= right.val) {
            head = left;
            head.next = combine(left.next, right);
        }
        else {
            head = right;
            head.next = combine(left, right.next);
        }
        return head;
        
    }
    
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) return head;
       
        ListNode slow = head, fast = head.next;
        
        // find middle element
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode left = head, right = slow.next;
        slow.next = null;
        
        // do merge sort
        left = sortList(left);
        right = sortList(right);
        
        return combine(left, right);
        
    }
}

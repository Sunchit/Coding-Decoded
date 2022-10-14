
// @saorav21994

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
    public ListNode deleteMiddle(ListNode head) {
        
        if (head == null || head.next == null)
            return null;
        
        if (head.next.next == null) {   // only 2 node exist
            head.next = null;
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head.next.next;
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null)
                fast = fast.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
            
    }
}

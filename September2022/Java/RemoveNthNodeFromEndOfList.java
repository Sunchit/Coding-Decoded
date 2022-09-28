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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = new ListNode(-1);
        slow.next = head;
        if (head.next == null) return null;
        while (n > 1) {
            if (fast.next == null) { fast = null; break; }
            fast = fast.next;
            n -= 1;
        }
        // System.out.println(fast.val);
        int flag = 0;
        while (fast != null && fast.next != null) {
            flag = 1;
            fast = fast.next;
            slow = slow.next;
        }
        if (flag == 0) { return head.next; }
        else {
            slow.next = slow.next.next;
        }
        return head;
    }
}

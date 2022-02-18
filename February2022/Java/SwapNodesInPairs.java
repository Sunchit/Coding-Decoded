
// @saorav21994
// TC : O(n)
// SC : O(1)


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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        
        ListNode cur = head;
        ListNode prev = preHead;
        ListNode next = cur.next;
        
        while (cur != null && next != null) {
            prev.next = next;
            cur.next = next.next;
            next.next = cur;
            
            if (cur.next == null || cur.next.next == null)
                break;
            prev = cur;
            cur = cur.next;
            next = cur.next;
        }
        return preHead.next;
    }
}

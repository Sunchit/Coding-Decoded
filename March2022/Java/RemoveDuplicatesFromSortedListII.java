
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = new ListNode(-1);
        ListNode cur = prev;
        
        while (head != null) {
            boolean duplicate = false;
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
                duplicate = true;
            }
            if (duplicate == false) {
                prev.next = head;
                prev = prev.next;
            }
            head = head.next;
        }
        prev.next = null;
        return cur.next;
    }
}

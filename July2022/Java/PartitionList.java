
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
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(0);
        ListNode start = res;
        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.val < x) {
                res.next = new ListNode(tmp.val);
                res = res.next;
            }
            tmp = tmp.next;
        }
        tmp = head;
        while (tmp != null) {
            if (tmp.val >= x) {
                res.next = new ListNode(tmp.val);
                res = res.next;
            }
            tmp = tmp.next;
        }
        return start.next;
    }
}

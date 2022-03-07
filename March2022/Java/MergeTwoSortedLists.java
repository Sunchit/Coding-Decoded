
// @saorav21994
// TC : O(n)
// SC : O(n)


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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode head = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.next = new ListNode(l1.val);
                res = res.next;
                l1 = l1.next;
            }
            else {
                res.next = new ListNode(l2.val);
                res = res.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            res.next = new ListNode(l1.val);
            res = res.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            res.next = new ListNode(l2.val);
            res = res.next;
            l2 = l2.next;
        }
        res.next = null;
        return head.next;
    }
}

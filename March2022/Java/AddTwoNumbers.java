
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        int carry = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val;
            sum += carry;
            tmp.next = new ListNode(sum%10);
            sum /= 10;
            carry = sum;
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {   // l2 remains
            while (l2 != null) {
                sum = carry + l2.val;
                tmp.next = new ListNode(sum%10);
                sum /= 10;
                carry = sum;
                tmp = tmp.next;
                l2 = l2.next;
            }
        }
        else if (l2 == null) {   // l1 remains
            while (l1 != null) {
                sum = carry + l1.val;
                tmp.next = new ListNode(sum%10);
                sum /= 10;
                carry = sum;
                tmp = tmp.next;
                l1 = l1.next;
            }
        }
        if (carry != 0) {
            tmp.next = new ListNode(carry);
        }
        return res.next;
    }
}


// @saorav21994

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode rem = node.next;
        // System.out.println(rem.val + " " + rem.next.val);
        node.val = rem.val;
        node.next = rem.next;
    }
}

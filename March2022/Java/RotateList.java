
// @saorav21994
// TC : O(n)
// SC : O(1)

// Note : The initial traversal for count can be omitted if it is guranteed that (k <= n) -> Move to kth node and then start 2 pointer traversal (1 at head and other at kth.next


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
    public ListNode rotateRight(ListNode head, int k) {
        
        int len = 0;
        ListNode tmp = head;
        ListNode prev = tmp;
        while (tmp != null) {
            len += 1;
            tmp = tmp.next;
        }
        
        if (k != 0 && len != 0) {
            k = k % len;
        }
        
        if (k == 0 || len == 0) {
            return head;
        }
        
        k = len - k;
        
        tmp = head;
        
        for (int i = 1; i <= k; i++) {
            prev = tmp;
            tmp = tmp.next;
        }
        
        ListNode start = tmp;
        
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        
        tmp.next = head;
        prev.next = null;
        
        return start;
    }
}

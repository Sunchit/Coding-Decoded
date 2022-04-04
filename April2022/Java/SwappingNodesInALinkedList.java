
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
    public ListNode swapNodes(ListNode head, int k) {
        int i = 1;
        ListNode cur = head;
        while (i < k) {
            cur = cur.next;
            i += 1;
        }
        
        ListNode tmp1 = cur;
        int n = k;
        while (cur.next != null) {
            n += 1;
            cur = cur.next;
        }
        // System.out.println("n=" + n);
        cur = head;
        k = n-k;
        i = 0;
        while (i < k) {
            cur = cur.next;
            i += 1;
        }
        // System.out.println(tmp1.val);
        int tmp2 = cur.val;
        cur.val = tmp1.val;
        tmp1.val = tmp2;
        return head;
    }
}

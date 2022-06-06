
// @saorav21994
// TC : O(max(m,n))
// SC : O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        int l1 = 0, l2 = 0;
        
        while (t1 != null) {
            l1 += 1;
            t1 = t1.next;
        }
        while (t2 != null) {
            l2 += 1;
            t2 = t2.next;
        }
        
        ListNode large = headA, small = headB;
        
        if (l1 < l2) {
            large = headB;
            small = headA;
        }
        
        int diff = Math.abs(l1-l2);
        while (diff > 0) {
            large = large.next;
            diff -= 1;
        }
        
        while (large != null && small != null) {
            if (large==small)
                return large;
            else {
                large = large.next;
                small = small.next;
            }
        }
        
        return null;
    }
}

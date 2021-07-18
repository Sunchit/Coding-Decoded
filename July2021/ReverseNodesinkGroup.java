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

    // TC : O(n)
    // SC : O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k ==1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;


        int totalNodes = 0;

        ListNode curr = head;

        // counts the total no of nodes
        while(curr!= null){
            totalNodes++;
            curr = curr.next;
        }

        curr = head;
        ListNode next = null;
        ListNode prev = dummy;

        while(totalNodes>=k){
            curr = prev.next;
            next = curr.next;

           for(int i=1;i<k;i++) {// k-1 times
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;

            }

            prev = curr;
            totalNodes = totalNodes - k;

        }
        return dummy.next;

    }
}
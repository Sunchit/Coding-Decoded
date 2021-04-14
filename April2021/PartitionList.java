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
    // SC  : O(1)
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(-1);
        ListNode greaterHead = new ListNode(-1);
        ListNode sIt = smallerHead;
        ListNode gIt = greaterHead;

        ListNode it = head;
        while(it!=null){
            if(it.val <x){
                // for smaller values
                sIt.next = it;
                it = it.next;
                sIt =sIt.next;
            } else{
                // for equal or greater comparisons
                gIt.next = it;
                it = it.next;
                gIt = gIt.next;
            }
        }

        sIt.next = greaterHead.next;
        gIt.next = null;

        return smallerHead.next;

    }
}
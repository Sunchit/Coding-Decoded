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
class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null ||head.next == null ){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;

        ListNode it = first;
        ListNode previt = null;
        ListNode newHead = null;
        while(it!=null && it.next!=null){


            first = it;

            second = it.next;
            if(previt!=null){
                previt.next = second;
            }
            if(newHead == null){
                newHead = second;
            }
            if(it.next!=null) {
                it = it.next.next;
            }

            second.next = first;
            first.next = it;
            previt = first;

        }

        return newHead;
    }
}
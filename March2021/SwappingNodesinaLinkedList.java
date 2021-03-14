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
    public ListNode swapNodes(ListNode head, int k) {
        k = k-1;
        ListNode firstN = head;
        while(k>0){
            firstN = firstN.next;
            k--;
        }

        ListNode f = firstN;
        ListNode secondN = head;
        while(f.next!=null){
            secondN = secondN.next;
            f = f.next;
        }

        int temp = firstN.val;
        firstN.val = secondN.val;
        secondN.val = temp;

        return head;


    }
}
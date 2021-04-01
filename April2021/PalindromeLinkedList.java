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
    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next==null){
            return true;
        }

        ListNode slow =head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next;
            if(fast!=null){
                fast = fast.next;
            }

            slow = slow.next;
        }

        //                  F
        // 1    2   3   2   1
        //              S
        //                  F
        // 1    2   2   1
        //      S   S

        if(fast!=null){
            slow = slow.next;
        }


        ListNode head2 = reverse(slow);
        ListNode head1 = head;

        while(head1!=null && head2!=null){
            if(head1.val !=head2.val){
                return false;
            }

            head1 = head1.next;
            head2 = head2.next;
        }


        return true;

    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}
// Problem Link: https://leetcode.com/problems/odd-even-linked-list/description/

// author: Mahesh Reddy B N

class Solution {
    public ListNode oddEvenList(ListNode head) {
    if(head ==null || head.next ==null || head.next.next == null) return head;
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenStart = head.next;
    while( odd.next!= null && even.next != null  ){
        odd.next = even.next;
        odd = odd.next;
        even.next = odd.next;
        even = even.next;
    }
    odd.next = evenStart;
    return head;
    }
}
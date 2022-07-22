
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
    public ListNode reverseBetween(ListNode head, int left, int right) {        
        if (head == null || head.next == null || left == right) {
            return head;
        }        
        ListNode preHead = new ListNode(-1);  
        preHead.next = head;        
        ListNode prev = preHead;
        
        for (int i = 0; i <= left-2; i++) {
            prev = prev.next;
        }        
        ListNode curr = prev.next;
        ListNode temp = null;
        ListNode reverseHead = null;
        for (int i = 0; i <= right-left; i++) {
            
            temp = curr.next;         
            curr.next = reverseHead;  
            
            reverseHead = curr;       
            curr = temp;              
            
        }
    
        prev.next.next = curr;
        prev.next = reverseHead;    
        return preHead.next;
    }
}

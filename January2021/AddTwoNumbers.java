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
    // TC : O(Max(length of l1, length of l2))
    // SC : O(Max(length of l1, length of l2))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }   
        if(l2 == null){
            return l1;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode it = dummy;
        int carry = 0;
        int sum = 0;
        while(l1!=null && l2!=null){
            sum = l1.val+l2.val + carry;
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            it.next = newNode;
            it = it.next;
            l1=l1.next;
            l2 =l2.next;
        }
        
        while(l1!=null){
            sum = l1.val+ carry;
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            it.next = newNode;
            it = it.next;
            l1=l1.next;
        }
        
        
        while(l2!=null){
            sum = l2.val + carry;
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            it.next = newNode;
            it = it.next;
            
            l2 =l2.next;
        }
        
        if(carry==1){
            ListNode newNode = new ListNode(1);
            it.next = newNode;
        }
        return dummy.next;
        

    }
}
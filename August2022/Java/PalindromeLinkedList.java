
// @saorav21994
// TC : O(n)
// SC : O(1)

// in-place

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
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        if (head == null || head.next == null)
            return true;
        
        
        // find mid point
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        ListNode curr = slow;
        prev = null;
        
        // reverse the 2nd half
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        
        slow = prev;
        
        // compare for palindrome
        
        while (head != null && slow != null) {
            if (head.val != slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        
        return true;
        
    }
}

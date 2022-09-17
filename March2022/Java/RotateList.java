
// @saorav21994
// TC : O(n)
// SC : O(1)

// Note : The initial traversal for count can be omitted if it is guranteed that (k <= n) -> Move to kth node and then start 2 pointer traversal (1 at head and other at kth.next


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
    public ListNode rotateRight(ListNode head, int k) {
        
        int len = 0;
        ListNode tmp = head;
        ListNode prev = tmp;
        while (tmp != null) {
            len += 1;
            tmp = tmp.next;
        }
        
        if (k != 0 && len != 0) {
            k = k % len;
        }
        
        if (k == 0 || len == 0) {
            return head;
        }
        
        k = len - k;
        
        tmp = head;
        
        for (int i = 1; i <= k; i++) {
            prev = tmp;
            tmp = tmp.next;
        }
        
        ListNode start = tmp;
        
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        
        tmp.next = head;
        prev.next = null;
        
        return start;
    }
}


// Author : @romitdutta10
// TC : O(N)
// SC: O(1)
// Problem :https://leetcode.com/problems/rotate-list/

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k <= 0) {
            return head;
        }
        int length = 0;
        
        ListNode temp = head;
        ListNode prev = null;
        
        while(temp != null) {
            prev = temp;
            length++;
            temp = temp.next;
        }
        
        k = k % length;
        
        if(k == 0) {
            return head;
        }
        
        prev.next = head;
        temp = head;
        
        
        
        
        
        k = length - k;
        
        while(k-- > 0) {
            prev = temp;
            temp = temp.next;
        }
        
        prev.next = null;
        head = temp;
        
        return head;
    }
}

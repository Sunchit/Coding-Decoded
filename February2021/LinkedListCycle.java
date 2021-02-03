/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    //TC: O(n)
    //SC: O(n)
    Set<ListNode> set = null;
    public boolean hasCycle(ListNode head) {
        set = new HashSet<>();
        ListNode it = head;
        while(it!=null){
            if(set.contains(it)){
                return true; // cycle found
            }
            set.add(it);
            it = it.next;
        }

        return false;

    }


    // TC : O(n)
    // SC : O(1)
    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null){
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
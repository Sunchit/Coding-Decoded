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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null ||lists.length ==0)        {
            return null;
        }
        return helper(lists, 0, lists.length -1);
    }

    private ListNode helper(ListNode[] lists, int low, int high){
        if(low> high){
            return null;
        } else if(low == high){
            return lists[low];
        } else{
            int mid = low +(high -low)/2;
            ListNode left = helper(lists, low, mid);
            ListNode right = helper(lists, mid+1, high);
            return merge(left, right);
        }
    }


    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode t= dummy;
        ListNode t1= l1;
        ListNode t2 = l2;
        while(t1!=null && t2!=null){
            if(t1.val < t2.val){
                t.next = t1;
                t = t.next;
                t1 = t1.next;
            } else{
                t.next = t2;
                t = t.next;
                t2 = t2.next;
            }
        }

        while(t1!=null){
            t.next = t1;
            t = t.next;
            t1 = t1.next;
        }

        while( t2!=null){
            t.next = t2;
            t = t.next;
            t2 = t2.next;

        }
        return dummy.next;


    }
}
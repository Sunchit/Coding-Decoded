
// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(-1);
        ListNode x=dummy;
        ListNode p1=list1;
        ListNode p2=list2;
        while(p1!=null&&p2!=null){
            if(p1.val<p2.val){
                x.next=p1;
                p1=p1.next;
            }else{
                x.next=p2;
                p2=p2.next;
            }
            x=x.next;
        }
        
        while(p1!=null){
             x.next=p1;
            p1=p1.next;
            x=x.next;
        }
        while(p2!=null){
             x.next=p2;
            p2=p2.next;
            x=x.next;
        }
        
        return dummy.next;
    }
}

// @saorav21994
// TC : O(n)
// SC : O(n)


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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode head = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.next = new ListNode(l1.val);
                res = res.next;
                l1 = l1.next;
            }
            else {
                res.next = new ListNode(l2.val);
                res = res.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            res.next = new ListNode(l1.val);
            res = res.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            res.next = new ListNode(l2.val);
            res = res.next;
            l2 = l2.next;
        }
        res.next = null;
        return head.next;
    }
}

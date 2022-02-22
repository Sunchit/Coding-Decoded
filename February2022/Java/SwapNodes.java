//Author Shobhit Behl(LC:shobhitbruh)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode one=head;
        ListNode two=head.next;
        ListNode three=two.next;
        two.next=one;
        one.next=swapPairs(three);
        
        return two;
    }
}
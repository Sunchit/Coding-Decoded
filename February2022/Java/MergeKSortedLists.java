// Author : Shobhit Behl(shobhitbruh)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        ListNode dummy=new ListNode(0);
        ListNode result=dummy;
        
        for(ListNode x:lists){
            ListNode temp=x;
            while(temp!=null){
                pq.add(temp.val);
                temp=temp.next;
            }
        }
        
        while(pq.size()>0){
            ListNode n=new ListNode(pq.remove());
            dummy.next=n;
            dummy=dummy.next;
        }
        
        return result.next;
    }
}
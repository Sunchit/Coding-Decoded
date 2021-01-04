class Solution {
    // TC : O(n+m)
    // SC: O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode it1 =l1;

        ListNode it2 =l2;

        ListNode it = dummyNode;

        while(it1!=null && it2!=null){
            if(it1.val<it2.val){
                it.next = it1;
                it1 = it1.next;
                it = it.next;
            } else{
                it.next = it2;
                it2 =it2.next;
                it = it.next;
            }
        }

        while(it1!=null){
            it.next = it1;
            it1 = it1.next;
            it = it.next;
        }

        while(it2!=null){
            it.next = it2;
            it2 = it2.next;
            it = it.next;
        }

        return dummyNode.next;

    }
}
class Solution {
	// TC : O(nlogn)
	public ListNode sortList(ListNode head) {
		// find the middle element of the list
		if(head == null || head.next ==null){
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev= null;
		while(fast!=null && fast.next!=null){
			prev = slow;
			fast= fast.next;
			slow = slow.next;
			if(fast!=null){
				fast = fast.next;
			}
		}
		// slow will point to middle element
		prev.next = null;


		ListNode first = sortList(head);
		ListNode  second = sortList(slow);

		return merge(first, second);
	}

	private ListNode merge(ListNode head1, ListNode head2){
		if(head1 ==null){
			return head2;
		}
		if(head2 ==null){
			return head1;
		}

		ListNode dummy = new ListNode(-1);
		ListNode it= dummy;

		while(head1!=null && head2!=null){
			if(head1.val < head2.val){
				it.next = head1;
				head1 = head1.next;
				it = it.next;
			} else {
				it.next = head2;
				head2 = head2.next;
				it = it.next;
			}
		}



		while(head1!=null){
			it.next = head1;
			head1 = head1.next;
			it = it.next;

		}




		while(head2!=null){
			it.next = head2;
			head2 = head2.next;
			it = it.next;

		}

		return dummy.next;
	}
}
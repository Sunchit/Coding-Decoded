
class Solution {
	// TC : O(n)
	// SC: O(1)
	public ListNode middleNode(ListNode head) {
		if(head == null || head.next==null){
			return head;
		}

		ListNode fastPointer=head, slowPointer= head;
		while(fastPointer!=null && fastPointer.next!=null){
			fastPointer =fastPointer.next;
			if(fastPointer!=null){
				fastPointer =fastPointer.next;
			}
			slowPointer = slowPointer.next;

		}
		return slowPointer;
	}
}
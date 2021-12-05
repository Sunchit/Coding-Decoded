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
	// TC : O(n)
	// SC : O(1)
	public ListNode oddEvenList(ListNode head) {
		if(head==null || head.next==null|| head.next.next==null){
			return head;
		}
		ListNode oddIt = head;
		ListNode evenIt = head.next;

		ListNode evenHead = evenIt;

		// todo:check even odd case
		while(oddIt.next!=null && evenIt.next!=null){
			oddIt.next = evenIt.next;
			oddIt = oddIt.next;

			if(oddIt!=null) {
				evenIt.next = oddIt.next;
				evenIt = evenIt.next;
			}

		}

		oddIt.next = evenHead;



		return head;


	}
}
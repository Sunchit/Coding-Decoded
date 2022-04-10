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

	public ListNode mergeNodes(ListNode head) {
		ListNode dummyHead = new ListNode(-1);
		ListNode newIt = dummyHead;
		ListNode it = head;
		while(it!=null){
			it = it.next;
			int sumNodes = 0;
			while(it!=null && it.val!=0){
				sumNodes +=  it.val;
				it = it.next;
			}

			if(sumNodes!=0) {
				newIt.next = new ListNode(sumNodes);
				newIt = newIt.next;
			}
		}
		return dummyHead.next;
	}
}
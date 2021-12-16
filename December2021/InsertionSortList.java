


//time complexity: O(n^2) as there are two while loops that can iterate n or n-1 times in worst conditions.

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

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode preInsert;
		ListNode toInsert;
		ListNode dummyHead = new ListNode(-5001);
		dummyHead.next = head;
		ListNode currIt = head;
		while (currIt != null && currIt.next != null) {
			if (currIt.val <= currIt.next.val) {
				currIt = currIt.next;
			} else {

				// out of sorting order
				toInsert = currIt.next;
				// Locate preInsert.
				preInsert = dummyHead;
				while (preInsert.next.val < toInsert.val) {
					preInsert = preInsert.next;
				}
				currIt.next = toInsert.next;
				// Insert toInsert after preInsert.
				toInsert.next = preInsert.next;
				preInsert.next = toInsert;
			}
		}

		return dummyHead.next;
	}
}

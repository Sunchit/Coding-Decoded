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
	public int getDecimalValue(ListNode head) {
		int no = 0;
		ListNode it = head;
		while (it != null){
			no = 2 *no+ it.val;

			it = it.next;
		}
		return no;
	}
}




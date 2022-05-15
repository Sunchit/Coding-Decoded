
// @saorav21994
// Use merge sort. Find the middle element and recursively partition to get each node. Finally merge/combine them together.

// TC : O(nlogn)
// SC : recursion -> internal stack used


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
    
    // merge
    public ListNode combine(ListNode left, ListNode right) {
        
        if (left == null) return right;
        if (right == null) return left;
        
        ListNode head = null;
        
        if (left.val <= right.val) {
            head = left;
            head.next = combine(left.next, right);
        }
        else {
            head = right;
            head.next = combine(left, right.next);
        }
        return head;
        
    }
    
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) return head;
       
        ListNode slow = head, fast = head.next;
        
        // find middle element
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode left = head, right = slow.next;
        slow.next = null;
        
        // do merge sort
        left = sortList(left);
        right = sortList(right);
        
        return combine(left, right);
        
    }
}
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

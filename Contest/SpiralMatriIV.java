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
	public int[][] spiralMatrix(int m, int n, ListNode head) {
		int[][] matrix = new int[m][n];
		int top =0;
		int bottom = m-1;
		int left =0;
		int right = n-1;

		int len = m*n;

		int count =0;

		int val=0;

		while(count<len){

			// add elements in matrix

			//Iterate over Top row
			for(int i = left; i<=right && count<len; i++){
				if(head !=null) {
					val = head.val;
					head = head.next;
				}  else {
					val=-1;
				}
				matrix[top][i] = val;
				count++;
			}

			top++;

			// travel downwards toward bottom
			for(int i = top; i<=bottom && count<len; i++){
				if(head !=null) {
					val = head.val;
					head=head.next;
				}  else {
					val=-1;
				}
				matrix[i][right] = val;
				count++;
			}
			right--;

			// travel left
			for(int i = right; i>=left && count<len; i--){
				if(head !=null) {
					val = head.val;
					head=head.next;
				}  else {
					val=-1;
				}
				matrix[bottom][i] = val;
				count++;
			}
			bottom--;

			// travel up
			for(int i = bottom; i>=top && count<len; i--){
				if(head !=null) {
					val = head.val;
					head=head.next;
				} else {
					val=-1;
				}
				matrix[i][left] = val;
				count++;
			}
			left++;
		}

		return matrix;
	}
}
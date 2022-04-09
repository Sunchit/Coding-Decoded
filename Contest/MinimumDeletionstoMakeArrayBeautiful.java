class Solution {

	// TC : O(n)
	// SC : O(1)
	public int minDeletion(int[] nums) {
		int d = 0;
		int n = nums.length;

		for (int i=0; i<n-1;i++) {
			int newIndex = i-d;
			if ((newIndex % 2 == 0) && nums[i] == nums[i+1]) {  d++; }

		}
		// size of the updated array if odd remove the last entry
		return ((n-d) % 2 == 0) ? d : d+1;
	}
}
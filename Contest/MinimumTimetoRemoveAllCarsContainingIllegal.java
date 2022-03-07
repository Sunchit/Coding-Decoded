class Solution {
	// TC: O(n)
	// SC : O(n) -> O(1)

	public int minimumTime(String s) {
		int n = s.length();
		int min = s.length();
		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = s.charAt(i) - '0';
		}

		int[] leftCost = new int[n];
		leftCost[0] = nums[0];

		for (int i = 1; i < n; i++) {
			leftCost[i] = Math.min(i+1, leftCost[i - 1] + (nums[i] == 1? 2: 0));
		}

		int[] rightCost = new int[n];
		rightCost[n-1] = nums[n-1];

		for (int i = n-2; i >= 0; i--) {
			rightCost[i] = Math.min(n - i, rightCost[i + 1] + (nums[i] == 1? 2: 0));
		}
		for (int i = 0; i < n; i++) {
			int right = (i == n-1) ?  0 : rightCost[i+1];
			int left = leftCost[i];
			min = Math.min(min, left +right);
		}

		return min;
	}
}

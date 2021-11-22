class Solution {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		int[] dp = new int[nums.length];
		return constructLDS(nums, dp, getLDSSize(nums, dp));
	}

	private int getLDSSize(int[] nums, int[] dp) {
		Arrays.sort(nums);
		Arrays.fill(dp, 1);
		int ldsSize = 1;

		for (int i = 1; i < nums.length; i++)
			for (int j = 0; j < i; j++)
				if (nums[i] % nums[j] == 0) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					ldsSize = Math.max(ldsSize, dp[i]);
				}

		return ldsSize;
	}

	private List<Integer> constructLDS(int[] nums, int[] dp, int ldsSize) {
		int prev = -1;
		LinkedList<Integer> lds = new LinkedList<Integer>();

		for (int i = dp.length - 1; i >= 0; i--)
			if (dp[i] == ldsSize && (prev == -1 || prev % nums[i] == 0)) {
				lds.addFirst(nums[i]);
				ldsSize--;
				prev = nums[i];
			}

		return lds;
	}
}
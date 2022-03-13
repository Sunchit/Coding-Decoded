class Solution {
	public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
		int n = nums.length;

		List<Integer> jIndices = new ArrayList<>();
		Set<Integer> set = new HashSet<>();

		//Get all possible indices.
		for (int j = 0;j < n; j++) {
			if (nums[j] == key) jIndices.add(j);
		}

		for (int i = 0; i < n; i++) {
			for (int j : jIndices) {
				// Get the Distinct POssible Indices with | i - j | <= k.
				if (Math.abs(i - j) <= k && nums[j] == key)
					set.add(i);
			}
		}

		List<Integer> ans = new ArrayList<>(set);
		Collections.sort(ans);
		return ans;
	}
}
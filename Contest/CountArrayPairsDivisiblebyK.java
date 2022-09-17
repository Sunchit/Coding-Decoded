class Solution {
	public long countPairs(int[] nums, int k) {
		long ans = 0;
		// UniqueGCD, Freq
		Map<Integer, Integer> gcds = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int gcdFromNo1 = findGcd(nums[i], k);

			for (int gcdFromNo2 : gcds.keySet()) {
				if ((long) gcdFromNo1 * gcdFromNo2 % k == 0) {
					ans += gcds.get(gcdFromNo2);
				}
			}
			gcds.put(gcdFromNo1, gcds.getOrDefault(gcdFromNo1, 0) + 1);
		}
		return ans;
	}


	private int findGcd(int x, int y) {
		if (x < y) {
			return findGcd(y, x);
		}
		return y == 0 ? x : findGcd(y, x % y);
	}

}
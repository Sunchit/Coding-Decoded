
class Solution {

	private int ans = Integer.MAX_VALUE;
	public int distributeCookies(int[] cookies, int k) {
		backtracking(cookies, 0, k, new int[k]);
		return ans;
	}

	void backtracking(int[] cookies, int index, int k, int[] cookiesDistribution) {
		if (index == cookies.length) {
			int max = 0;
			for (int cookie : cookiesDistribution) max = Math.max(max, cookie);
			ans = Math.min(ans, max);
			return;
		}

		for (int i = 0; i < k; i++) {
			cookiesDistribution[i] += cookies[index];
			backtracking(cookies, index + 1, k, cookiesDistribution);
			cookiesDistribution[i] -= cookies[index];
		}
	}
}
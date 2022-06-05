class Solution {
	// TC : O(n)
	// SC : O(n)
	public int totalStrength(int[] strength) {
		int n = strength.length;

		int MOD = 1_000_000_007;

		long[] preSum = new long[n + 1];

		long[] prePrefix = new long[n + 2];

		for (int i = 0; i < n; i++) {
			preSum[i + 1] = (preSum[i] + strength[i]) % MOD;
		}
		for (int i = 0; i <= n; i++) {
			prePrefix[i + 1] = (prePrefix[i] + preSum[i]) % MOD;
		}

		int[] left = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < strength.length; i++) {
			while (!stack.isEmpty() && strength[i] <= strength[stack.peek()]) {
				stack.pop();
			}
			left[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}

		int[] right = new int[n];
		stack = new Stack<Integer>();
		for (int i = strength.length - 1; i >= 0 ; i--) {
			while (!stack.isEmpty() && strength[i] < strength[stack.peek()]) {
				stack.pop();
			}
			right[i] = stack.isEmpty() ? n : stack.peek();
			stack.push(i);
		}

		long ans = 0;
		for (int i = 0; i < n; i++) {

			ans += ((prePrefix[right[i] + 1] - prePrefix[i + 1]) * (i - left[i]) % MOD + MOD - (prePrefix[i + 1] - prePrefix[left[i] + 1]) * (right[i] - i) % MOD) * strength[i];
			ans %= MOD;

		}
		return (int)ans;
	}
}
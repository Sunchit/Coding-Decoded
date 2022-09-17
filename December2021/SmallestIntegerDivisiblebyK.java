class Solution {
	// TC : O(K)
	// SC : O(1)
	public int smallestRepunitDivByK(int k) {
		if (k % 2 == 0 || k % 5 == 0) return -1;
		int remainder = 0;
		for (int counter = 1; counter <= k; counter++) {
			remainder = (remainder * 10 + 1) % k;
			if (remainder == 0) return counter;
		}
		return -1;
	}
}
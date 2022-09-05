class Solution {
	public int longestNiceSubarray(int[] nums) {

		int startIndex = 0;
		int ans = 0;

		int bitsUnion = 0;

		for (int i = 0; i < nums.length; i++) {
			int newEl =  nums[i];

			while ((bitsUnion & newEl) != 0) {
				// violates the window
				int startingEl =  nums[startIndex];
				// Remove elements from start
				bitsUnion ^= startingEl;
				startIndex++;
			}
			// happy case
			// Including new element
			bitsUnion   = bitsUnion | newEl;
			ans = Math.max(ans, i - startIndex + 1);
		}
		return ans;
	}
}


class Solution {

	//  TC : O(n)
// SC : O(1)
	public int minSwaps(int[] nums) {
		int n = nums.length;
		int totalOnes = 0;
		int circular[] = new int[2 * n];

		for (int i = 0; i <  n; i++) {
			totalOnes += nums[i];
			circular[i] = nums[i];
			circular[n+i] = nums[ i];
		}


		int start = 0;
		int end = 0;
		int zeroCount = 0;
		int minZero = Integer.MAX_VALUE;
		for (; end < totalOnes; end++) {
			if(circular[end] == 0){
				zeroCount++;
			}
		}

		for (; end < circular.length; end++) {

			if(circular[end] == 0){
				zeroCount++;
			}

			if (end - start + 1 == totalOnes) {
				zeroCount = Math.min(minZero, zeroCount);
			} else if (end - start + 1 > totalOnes) {
				if(circular[start] == 0){
					zeroCount--;
				}

				minZero = Math.min(minZero, zeroCount);
				start++;
			}

		}
		return minZero;
	}
}
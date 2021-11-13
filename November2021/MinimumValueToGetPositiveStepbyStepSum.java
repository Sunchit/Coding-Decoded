class Solution {
	// TC : O(n)
	// SC: O(1)
	public int minStartValue(int[] nums) {
		int min = 0;
		int prefixSum = 0;
		for(int el: nums){
			prefixSum += el;
			min = Math.min(min, prefixSum);
		}
		return min <0 ? Math.abs(min) + 1 : 1;

	}
}
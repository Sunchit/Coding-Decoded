class Solution {
	// Tc: O(n)
	// SC : O(n)
	public int findFinalValue(int[] nums, int original) {
		Set<Integer> set = new HashSet<>();
		for(int el: nums){
			set.add(el);
		}

		while(set.contains(original)){
			original = 2*original;
		}
		return original;

	}
}
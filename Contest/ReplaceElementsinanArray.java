class Solution {
	// TC : O(nums.length) + O(operations.length)
	// SC: O(nums.length)
	public int[] arrayChange(int[] nums, int[][] operations) {
		// <Val, Index>
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++)  {
			map.put(nums[i],i);
		}

		for(int[] op: operations) {
			int oldVal = op[0];
			int newVal = op[1];
			int index = map.get(op[0]);
			// replace
			nums[index] = newVal;

			// update the index
			map.put(newVal,index);

			// remove element from map
			map.remove(oldVal);
		}
		return nums;
	}
}
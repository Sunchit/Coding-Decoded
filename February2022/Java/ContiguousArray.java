class Solution {
	// TC : O(n)
	// SC : O(n)
	public int findMaxLength(int[] nums) {
		if(nums.length==0){
			return 0;
		}

		// PrefixSum, Index
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int prefixSum = 0;
		int maxLen = 0;
		for(int i=0;i<nums.length;i++){
			prefixSum = prefixSum+ ((nums[i] ==0) ? -1: 1);

			if(map.containsKey(prefixSum)){
				if(maxLen<i-map.get(prefixSum)){
					maxLen = i- map.get(prefixSum);
				}
			}
			map.putIfAbsent(prefixSum, i);
		}
		return maxLen;
	}
}
class Solution {
	// TC : Nlogn + qlogn

	// SC : O(n)
	public int[] answerQueries(int[] nums, int[] queries) {
		Arrays.sort(nums);
		int[] prefixSum = new int[nums.length];
		prefixSum[0] = nums[0];

		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(prefixSum[0], 1);
		for(int i=1;i<nums.length;i++){
			prefixSum[i] = prefixSum[i-1] + nums[i];
			map.put(prefixSum[i],i+1);
		}

		int[] ans = new int[queries.length];
		int i=0;
		for(int query : queries){
			Map.Entry<Integer, Integer> entry = map.floorEntry(query);
			if(entry!=null){
				ans[i] = entry.getValue();
			}
			i++;
		}

		return ans;


	}
}
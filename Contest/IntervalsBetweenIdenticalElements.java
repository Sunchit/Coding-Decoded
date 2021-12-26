class Solution {
	public long[] getDistances(int[] arr) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			int el = arr[i];
			Set<Integer> indices = map.getOrDefault(el, new HashSet<>());
			indices.add(i);
			map.put(el, indices);
		}

		long[] ans = new long[arr.length];

		for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
			Set<Integer> index = entry.getValue();

			for(Integer i : index){
				long count = 0;
				for(Integer j : index){
					count += Math.abs(j-i);
				}
				ans[i] = count;
			}
		}
		return ans;
	}
}



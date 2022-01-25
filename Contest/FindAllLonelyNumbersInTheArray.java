class Solution {
	// TC : O(n)
	public List<Integer> findLonely(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int el: nums){
			map.put(el, map.getOrDefault(el, 0)+1);
		}
		List<Integer> ans = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			if(entry.getValue()>1){
				continue;
			} else{
				if(map.containsKey(entry.getKey()-1) || map.containsKey(entry.getKey()+1)){
					continue;
				} else {
					ans.add(entry.getKey());
				}
			}
		}
		return ans;
	}
}
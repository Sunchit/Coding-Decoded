class Solution {
	// SC : O(1)
	// TC : O(n*m)
	public List<Integer> intersection(int[][] nums) {
		int[] freq = new int[1001];

		for(int[] num: nums){
			for(int el: num){
				freq[el]++;
			}
		}
		List<Integer> ans = new ArrayList<>();
		int len = nums.length;
		for(int i=1;i<1001;i++){
			if(freq[i] == len){
				ans.add(i);
			}
		}

		return ans;
	}
}
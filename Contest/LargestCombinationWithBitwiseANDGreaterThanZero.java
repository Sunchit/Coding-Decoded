class Solution {

	// TC :O(32 * len(candidates))
	public int largestCombination(int[] candidates) {
		int[] binarySetCount = new int[32];
		for(int i=0;i<binarySetCount.length;i++){
			for(int el: candidates){
				if(((el>>i) & 1) == 1){
					binarySetCount[i]++;
				}
			}
		}

		int ans = 0;
		for(int el: binarySetCount){
			ans = Math.max(ans, el);
		}
		return ans;
	}
}
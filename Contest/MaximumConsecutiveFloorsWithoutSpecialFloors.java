class Solution {
	// TC : O(nlogn)
	// SC : O(1)
	public int maxConsecutive(int bottom, int top, int[] special) {

		Arrays.sort(special);
		int start = bottom;
		int end  = top;
		int ans = 0;
		for(int i=0;i<special.length;i++){
			int specialFloorIndex = special[i];
			int diff = specialFloorIndex -  start;
			ans = Math.max(ans, diff);
			start = specialFloorIndex+1;
		}

		ans = Math.max(ans, end - special[special.length-1]);
		return ans;
	}
}
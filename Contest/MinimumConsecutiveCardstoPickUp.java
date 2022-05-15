class Solution {
	// TC : O(n)
	// SC : O(1)
	public int minimumCardPickup(int[] cards) {

		int[] lastIndex = new int[1000001];
		Arrays.fill(lastIndex, -1);
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<cards.length;i++){
			if(lastIndex[cards[i]]!=-1){
				ans = Math.min(i - lastIndex[cards[i]]+1, ans);

			}

			lastIndex[cards[i]] = i;
		}

		return ans == Integer.MAX_VALUE ? -1: ans;



	}
}
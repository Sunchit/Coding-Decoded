class Solution {

	// TC : O(NLogN)
	// SC : O(1)
	public int maximumCandies(int[] candies, long k) {

		int max = 0;

		for(int candy : candies)
			max = Math.max(max, candy);

		int low = 1;
		int high = max;

		while(low < high) {
			int mid = low + (high-low)/2;
			// System.out.println("Low" + low + " "+mid + " " + high);
			if(canAllocateCandies(candies, k, mid)) {
				low = mid+1;
			} else {
				high = mid ;
			}
		}
		return  canAllocateCandies(candies, k, low) ? low : low-1;
	}

	private boolean canAllocateCandies(int[] candies, long k, int pileSize) {
		if(pileSize == 0)
			return true;
		long totalChildrenSupported = 0;
		for(int candy : candies) {
			totalChildrenSupported += candy / pileSize;
			//System.out.println("Total Piles" + totalPiles);
			if(totalChildrenSupported >= k)
				return true;
		}
		return false;
	}
}
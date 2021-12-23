class Solution {
	public int minCostToMoveChips(int[] position) {
		int even = 0, odd = 0;

		for(int p : position){
			if(p%2==0) even++;
			else odd++;
		}

		return Math.min(even,odd);
	}
}
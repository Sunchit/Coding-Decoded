class Solution {
	public int maximumWealth(int[][] accounts) {
		int max = Integer.MIN_VALUE;
		for(int[] account:accounts){
			int currWealth = 0;
			for(int wealth : account) {
				currWealth += wealth;
			}
			max = Math.max(currWealth, max);
		}
		return max;

	}
}
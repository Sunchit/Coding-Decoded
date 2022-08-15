class Solution {
	public int edgeScore(int[] edges) {
		long[] countSum = new long[edges.length];

		for(int i = 0;i<edges.length;i++) {
			countSum[edges[i]] = countSum[edges[i]]  + i;
		}

		long max = 0l;
		int ans = 0;
		for(int i=0;i<countSum.length;i++){
			if(countSum[i] > max) {
				max = countSum[i];
				ans = i;
			}
		}
		return ans;
	}
}
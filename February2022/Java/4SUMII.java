class Solution {
	// TC : O(n2)
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		// need to store the frequency as well
		// S_AB, Freq
		Map<Integer, Integer> map  = new HashMap<>();
		for(int i=0;i<A.length;i++){
			for(int j=0;j<B.length;j++){
				int sum_AB = A[i]+B[j];
				map.put(sum_AB, map.getOrDefault(sum_AB,0)+1);
			}
		}
		int ans =0;
		for(int i=0;i<C.length;i++){
			for(int j=0;j<D.length;j++){
				int sum_CD = C[i]+D[j];
				int sum_AB = -sum_CD;
				ans += map.getOrDefault(sum_AB,0);
			}
		}
		return ans;
	}
}
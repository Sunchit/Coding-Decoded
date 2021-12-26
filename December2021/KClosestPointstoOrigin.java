class Solution {
	// TC : O(nlogk)
	// SC : O(k)
	public int[][] kClosest(int[][] points, int k) {
		// we need max heap
		// X, Y coordinate of a point
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (+ b[0]*b[0] +b[1]*b[1] -a[0]*a[0] - a[1]*a[1] ));

		for(int[] pt: points){
			pq.offer(pt);
			if(pq.size()>k){
				pq.poll();
			}
		}

		int[][] res = new int[pq.size()][2];
		int count = 0;
		while(!pq.isEmpty()){
			res[count] = pq.poll();
			count++;
		}
		return res;
	}
}
class Solution {
	public int closestMeetingNode(int[] edges, int node1, int node2) {

		int n = edges.length;

		int[] dist1 = new int[n];
		Arrays.fill(dist1, -1);

		int[] dist2 = new int[n];
		Arrays.fill(dist2, -1);

		dist1[node1] = 0;
		dist2[node2] = 0;

		int dist = 0;
		int i = node1;

		while(true){
			dist1[i] = dist++;
			i = edges[i];
			if(i==-1 || dist1[i]!=-1) { break;  }
		}

		i = node2;
		dist = 0;
		while(true){
			dist2[i] = dist++;
			i = edges[i];
			if(i==-1 || dist2[i]!=-1) { break; }
		}

		int ans = -1;
		int mini = Integer.MAX_VALUE;

		// Smallest because we are going iteratively
		for( i = 0; i < n; i++){

			if(dist1[i]==-1 || dist2[i]==-1)continue;

			if(mini > Math.max(dist1[i], dist2[i])){
				mini = Math.max(dist1[i], dist2[i]);
				ans = i;
			}
		}
		return ans;
	}
}
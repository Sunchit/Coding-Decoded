class Solution {
	public int longestCycle(int[] edges) {
		int ans = -1;

		int[][] cycleTracker = new int[edges.length][2];

		// Distance, Cycle Identifier (Source Identifier)
		Arrays.fill(cycleTracker, new int[]{-1, -1});

		for (int i = 0; i < edges.length; i++) {
			int dist = 0;

			int j = i;

			while( j != -1 ) {


				int distFromSourceId = cycleTracker[j][0];
				int cycleIdentifier = cycleTracker[j][1];

				if (distFromSourceId == -1) {
					cycleTracker[j] = new int[]{ dist++, i};
				} else {
					if (cycleIdentifier == i) {
						ans = Math.max(ans, dist - distFromSourceId);
					}
					break;
				}
				j = edges[j];
			}
		}
		return ans;
	}
}
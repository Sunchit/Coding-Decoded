class Solution {
	// Idea: Build as a graph
	// count the number of detonation when starting with each bomb
	public int maximumDetonation(int[][] bombs) {
		Map<Integer, List<Integer>> neighbors = buildNeighbors(bombs);

		int maxCount = 0;
		for (int startBomb = 0; startBomb < bombs.length; startBomb++) {
			int count = countDetonationsFrom(startBomb, neighbors);
			maxCount = Math.max(maxCount, count);
		}

		return maxCount;
	}

	private Map<Integer, List<Integer>> buildNeighbors(int[][] bombs) {
		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < bombs.length; i++) {
			List<Integer> neighbors = new ArrayList<>();

			long x1 = bombs[i][0];
			long y1 = bombs[i][1];
			long r1 = bombs[i][2];

			for (int j = 0; j < bombs.length; j++) {
				long x2 = bombs[j][0];
				long y2 = bombs[j][1];

				if (i != j) {
					if ((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) <= r1*r1) {
						neighbors.add(j);
					}
				}
			}

			graph.put(i, neighbors);
		}

		return graph;
	}

	// BFS
	private int countDetonationsFrom(int startIndex, Map<Integer, List<Integer>> neighbors) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(startIndex);
		Set<Integer> reachable = new HashSet<>();
		reachable.add(startIndex);

		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				int bomb = queue.poll();

				for (int neighbor: neighbors.get(bomb)) {
					if (!reachable.contains(neighbor)) {
						queue.add(neighbor);
						reachable.add(neighbor);
					}
				}
			}
		}
		// the no of bombs that can be detomated if we start with startIndex
		return reachable.size();
	}
}
class Solution {

	private class Point {
		long distance;
		int node;
		public Point(long distance, int node) {
			this.distance = distance;
			this.node = node;
		}
	}

	public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		Map<Integer, List<int[]>> reversedGraph = new HashMap<>();
		for (int[] edge: edges) {
			graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
			reversedGraph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
		}
		Map<Integer, Long> dist1 = dijkstra(n, graph, src1);
		Map<Integer, Long> dist2 = dijkstra(n, graph, src2);
		Map<Integer, Long> dist3 = dijkstra(n, reversedGraph, dest);
		long res = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (dist1.containsKey(i) && dist2.containsKey(i) && dist3.containsKey(i))
				res = Math.min(res, dist1.get(i) + dist2.get(i) + dist3.get(i));
		}
		return res == Long.MAX_VALUE ? -1 : res;
	}

	public Map<Integer, Long> dijkstra(int n, Map<Integer, List<int[]>> graph, int src) {
		PriorityQueue<Point> pq = new PriorityQueue<Point>((a, b) -> (a.distance - b.distance < 0 ? -1 : 1));
		pq.offer(new Point(0, src)); //<distance, node>
		Map<Integer, Long> dist = new HashMap<>();//合并了visited和distance array
		int[] pre = new int[n];
		Point onePoint = new Point(0, 0);
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			long curDistance = cur.distance;
			int curNode = cur.node;
			if (dist.containsKey(curNode)) continue;
			dist.put(curNode, curDistance);
			for (int[] edge: graph.getOrDefault(curNode, new ArrayList<>())) {
				int nei = edge[0], cost = edge[1];
				if (!dist.containsKey(nei)) {
					Point insert = new Point(curDistance + cost, nei);
					pq.offer(insert);
				}
			}
		}
		return dist;
	}



}
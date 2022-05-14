class Solution {

	private class Node{
		private int target;
		private int distance;

		public Node(int target, int dist){
			this.target = target;
			this.distance = dist;
		}

	}
	public int networkDelayTime(int[][] times, int N, int K) {
		// Min heap
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b) -> (a.distance - b.distance));

		// Source Id, Connections that exist in the graph
		Map<Integer, Set<Node>>  map = buildGraph(times);
		Set<Integer> visited =  new HashSet<>();

		pq.offer(new Node(K, 0));

		int totalTime = 0;
		while(!pq.isEmpty()){
			int size = pq.size();
			while(size-->0){
				Node head = pq.poll();

				if(visited.contains(head.target)){
					continue;
				}
				visited.add(head.target);

				totalTime = Math.max(totalTime, head.distance);


				if(visited.size() == N){
					return totalTime;
				}
				if(map.containsKey(head.target))
					for(Node children: map.get(head.target)){
						int childTime = children.distance + head.distance;
						pq.offer(new Node(children.target, childTime));
					}
			}


		}
		return -1;
	}


	private Map<Integer, Set<Node>> buildGraph(int[][] times){
		Map<Integer, Set<Node>> map = new HashMap<>();
		for(int[] time: times){
			map.putIfAbsent(time[0], new HashSet<>());
			map.get(time[0]).add(new Node(time[1] ,time[2]));

		}
		return map;
	}
}
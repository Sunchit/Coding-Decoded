class Solution {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		// find the level using BFS search

		List<Integer> res = new ArrayList<>();
		if (n <= 0) return res;
		if (n == 1) {
			res.add(0);
			return res;
		}

		Map<Integer, Set<Integer>> map = new HashMap<>();

		int[] degree = new int[n];

		for(int[] edge: edges){

			degree[edge[0]]++;
			degree[edge[1]]++;
			map.putIfAbsent(edge[0], new HashSet<>());
			map.get(edge[0]).add(edge[1]);
			map.putIfAbsent(edge[1], new HashSet<>());
			map.get(edge[1]).add(edge[0]);

		}

		Queue<Integer> leaves = new LinkedList<>();


		for(int i=0;i<n;i++){
			//System.out.println("Indegree is "+ indegree[i] + " i is "+ i);

			if(degree[i] == 1){

				// add in queue
				leaves.offer(i);
			}
		}

		int count = n;
		while(count>2){

			int size = leaves.size();
			count = count-size;
			while(size-->0){
				Integer leaf = leaves.poll();
				for(Integer connection : map.get(leaf)){
					degree[connection]--;
					// map.get(connection).remove(leaf);
					if(degree[connection] == 1){
						leaves.offer(connection);
					}
				}

			}

		}
		return new ArrayList<>(leaves);

	}


}
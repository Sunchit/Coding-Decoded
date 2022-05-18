class Solution {

	// TC : O(E)
	private int nextId = 0;

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		List<Integer>[] graph = new ArrayList[n];

		for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

		for(List<Integer> connection :connections) {
			graph[connection.get(0)].add(connection.get(1));
			graph[connection.get(1)].add(connection.get(0));
		}


		List<List<Integer>> ans = new ArrayList<>();
		boolean[] visited = new boolean[n];

		int[] lowestId = new int[n];

		tarjanAlgorithm(graph, -1, 0, visited, ans, lowestId);
		return ans;
	}


	public void tarjanAlgorithm(List<Integer>[] graph, int parentId, int nodeId,  boolean[] visited, List<List<Integer>> ans, int []lowestId) {


		visited[nodeId] = true;

		lowestId[nodeId] = nextId;

		nextId++;

		int currentNodeLowestId = lowestId[nodeId];

		for(int neighbourId : graph[nodeId]) {

			if(neighbourId == parentId) continue;

			if(!visited[neighbourId])  {
				tarjanAlgorithm(graph, nodeId, neighbourId, visited, ans, lowestId);
			}

			lowestId[nodeId] = Math.min(lowestId[nodeId], lowestId[neighbourId]);

			if(currentNodeLowestId < lowestId[neighbourId]) {                                  ans.add(Arrays.asList(nodeId, neighbourId));
			}
		}


	}

}
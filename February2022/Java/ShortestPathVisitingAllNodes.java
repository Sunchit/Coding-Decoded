class Solution {
	public int shortestPathLength(int[][] graph) {
		if(graph.length==1)
			return 0;

		int finalState = (1 << graph.length) - 1;
		// {i, BitState}
		Queue<int []> qu = new LinkedList<>();

		//Adding all nodes initially because we can start anywhere.
		for(int i=0; i<graph.length; i++) {
			qu.add(new int [] {i, 1 << i});

		}

		//[no of many nodes][each node may have 2^n visited bit]
		int [][] visitedMap = new int [graph.length][finalState+1];


		int shortestPath = 0;
		while(!qu.isEmpty()){
			int size = qu.size();
			shortestPath++;
			for(int i=0; i<size; i++){
				int [] head = qu.poll();
				int nodeId = head[0];
				int visitedNodeBitState = head[1];
				for(int neighbor : graph[nodeId]){
					int newVisitedNodeBitState = visitedNodeBitState | (1 << neighbor);

					//If the same node was visited again with same visitedNodeBit, it means this node can be skipped, For example: 1->0->1->0.  First 1 we have {1, 10}, then we have {0, 11}, then we will have {1, 11}. Lastly, we have {0, 11} which is a state we already had before. So we don't visit this again.

					if(visitedMap[neighbor][newVisitedNodeBitState] == 1)               continue;
					visitedMap[neighbor][newVisitedNodeBitState] = 1;                  if(newVisitedNodeBitState==finalState)
						return shortestPath;
					qu.add(new int [] {neighbor, newVisitedNodeBitState});
				}
			}
		}
		return -1;
	}
}

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




// @saorav21994
// TC : O(n*2^n)
// SC : O(n*2^n)


class Solution {
    
    public int shortestPathLength(int[][] graph) {
        
        if (graph.length == 1)
            return 0;
        
        int n = graph.length;
        Set<Integer> [] visited = new HashSet[n];
        Queue<Node> queue = new LinkedList<>();
        
        int finalMask = (1 << n) - 1;   // (2^n) - 1 -> all bit set
        
        // Add all nodes to queue, as all of them can be starting nodes
        for (int i = 0; i < n; i++) {
            int mask = (1 << i);
            queue.offer(new Node(i, 0, mask));
            visited[i] = new HashSet<>();
            visited[i].add(mask);
        }
     
        // BFS traversal
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.mask == finalMask)
                return curNode.steps;
            for (int neighbor : graph[curNode.nodeVal]) {
                int newMask = curNode.mask | (1 << neighbor);

                if (!visited[neighbor].contains(newMask)) {
                    visited[neighbor].add(newMask);
                    queue.offer(new Node(neighbor, curNode.steps+1, newMask));
                }
            }
        }
        return -1;
        
    }
    
    
    public class Node {
        int nodeVal;
        int steps;
        int mask;
        
        Node (int nodeVal, int steps, int mask) {
            this.nodeVal = nodeVal;
            this.steps = steps;
            this.mask = mask;
        }
        
    }
    
    
}

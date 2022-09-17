


class Solution {
        public int reachableNodes(int[][] edges, int maxMoves, int n) {
        int[][] graph = new int[n][n];

        for (int[] edge : graph) {
            Arrays.fill(edge, -1);
        }
        for (int[] edge: edges) {
            // source -> end = Distance / Intermediatory nodes
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }
        int ans  = 0;

        boolean[] visited = new boolean[n];
        // Comparator on the basis of max moves possible
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        pq.add(new int[] {0, maxMoves});

        while (!pq.isEmpty()) {
            int[] nearestEl = pq.poll();
            int nearestNodeId = nearestEl[0];
            int maxMovesRemaining = nearestEl[1];
            if (visited[nearestNodeId]) {
                continue;
            }
            visited[nearestNodeId] = true;
            // beacuse you are visiting the curr node
            ans++;


            for (int nei = 0; nei < n; nei++) {
                if (graph[nearestNodeId][nei] != -1) {

                     if (!visited[nei] && maxMovesRemaining >= graph[nearestNodeId][nei] + 1) {

                        pq.add(new int[]{nei, maxMovesRemaining - graph[nearestNodeId][nei] - 1});
                    }

                    int movesCost = Math.min(maxMovesRemaining, graph[nearestNodeId][nei]);

                    graph[nei][nearestNodeId] -= movesCost;
                    graph[nearestNodeId][nei] -= movesCost;

                    ans += movesCost;




                }
            }
        }

        return ans;
    }
}
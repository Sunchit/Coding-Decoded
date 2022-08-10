// https://leetcode.com/problems/reachable-nodes-with-restrictions/
// @author: anuj0503
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];
        int result = 0;

        for (int r : restricted){
            visited[r] = true;
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            graph.putIfAbsent(u, new ArrayList<>());
            ArrayList<Integer> al = graph.get(u);
            al.add(v);
            graph.put(u, al);

            graph.putIfAbsent(v, new ArrayList<>());
            al = graph.get(v);
            al.add(u);
            graph.put(v, al);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()){
            int size = queue.size();

            while (size-->0){
                int head = queue.poll();

                if(visited[head]){
                    continue;
                }

                visited[head] = true;
                result++;

                for(int neighbour : graph.get(head)) {
                    queue.offer(neighbour);
                }
            }
        }

        return result;

    }
}

// @saorav21994

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        // Implement BFS
        
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                tree.get(manager[i]).add(i);
            }
        }
        
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[] {headID, informTime[headID]/*time taken*/});
        
        int maxTime = 0;
        
        while (!queue.isEmpty()) {
            int [] pair = queue.poll();
            
            int node = pair[0];
            int time = pair[1];
            maxTime = Math.max(maxTime, time);
            
            for (int child : tree.get(node)) {
                queue.offer(new int[] {child, time+informTime[child]});
            }
        }
        
        return maxTime;
    }
}

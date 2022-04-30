
// @saorav21994
// TC : O(n^2) -> we need to find cost of all possible edges
// SC : O(n)

// Prim's algorithm for finding minimum spanning tree without using heap to reduce time complexity.

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int minCost = 0;
        int edges = 0;
        
        int [] cost = new int[n];
        boolean [] visited = new boolean[n];
        
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        cost[0] = 0;        // starting node
        
        for ( ; edges < n; edges++) {
            int curCost = Integer.MAX_VALUE;
            int curPoint = -1;
            
            for (int i = 0; i < n; i++) {
                if (!visited[i] && cost[i] < curCost) {
                    curCost = cost[i];
                    curPoint = i;
                }
            }
            
            minCost += curCost;
            visited[curPoint] = true;
            
            for (int i = 0; i < n; i++) {
                curCost = Math.abs(points[i][0] - points[curPoint][0]) + Math.abs(points[i][1] - points[curPoint][1]);
                
                if (!visited[i] && cost[i] > curCost)
                    cost[i] = curCost;
            }
        }
        
        return minCost;
        
    }
}

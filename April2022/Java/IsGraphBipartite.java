
// @saorav21994
// Graph coloring method (k = 2 for bipartite). Try to assign alternating color to parent and child. If not possible at any point return false.
// TC : O(V+E)
// SC : O(V)
    

class Solution {
    
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int [] color = new int[v];
        Arrays.fill(color, -1);
        int curColor = 0;
        
        for (int i = 0; i < v; i++) {
            if (color[i] == -1) // not visited / colored
                if (!dfs(graph, color, i, (curColor+1)%2))
                    return false;
        }
        
        return true;
    }
    
    public boolean dfs(int [][] graph, int [] color, int vertex, int curColor) {
        
        if (color[vertex] != -1 && color[vertex] != curColor)         // parent color same as child
            return false;       
        
        if (color[vertex] != - 1)       // color assigned already and is correct for bipartite
            return true;
        
        // color[vertex] = -1   -> unassigned, so assign it
        
        color[vertex] = curColor;
        
        // Repeat for all connected vertex of current vertex (basically for all edges of current vertex)
        
        for (int neiVertex : graph[vertex]) {
            if (!dfs(graph, color, neiVertex, (curColor+1)%2))
                return false;
        }
        
        return true;
    }
}

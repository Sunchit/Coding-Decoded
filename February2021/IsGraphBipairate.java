class Solution {

    // O(n2)
    // O(n)
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] color = new int[len];

        Arrays.fill(color, -1);

        for(int i=0;i<len;i++){
            if(color[i] == -1){
                color[i] = 1;
                if(!dfs(i, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int index, int[][] graph, int[] color){
        int currentColor = color[index];

        for(int connectingIndex : graph[index]){
            if(color[connectingIndex] == currentColor){
                return false;
            }
            if(color[connectingIndex] == -1){
                color[connectingIndex] = 1 - currentColor;
//                  if(currentColor == 1) {
//                      color[connectingIndex] = 0;
//                  }

//                 if(currentColor == 0) {
//                      color[connectingIndex] = 1;
//                  }
                if(!dfs(connectingIndex, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }


}
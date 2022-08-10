// https://leetcode.com/problems/flower-planting-with-no-adjacent/
// @author: anuj0503
class Solution {
    int[] result;
    public int[] gardenNoAdj(int n, int[][] paths) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        result = new int[n];
        
        for(int i = 0; i <= n; i++) graph.put(i, new ArrayList<Integer>());
        
        for(int[] path : paths){
            int u = path[0];
            int v = path[1];
            
            ArrayList<Integer> al = graph.get(u);
            al.add(v);
            graph.put(u, al);
            
            al = graph.get(v);
            al.add(u);
            graph.put(v, al);
        }

        getSolution(1, graph, n);
        
        return result;
    }
    
    private boolean getSolution(int index, HashMap<Integer, ArrayList<Integer>> graph, int n){
        if(index == n + 1) return true;
        
        for (int flower = 1; flower <= 4; flower++){
            boolean canBeUsed = true;
            for (Integer neighbour : graph.get(index)){
                if(result[neighbour - 1] == flower){
                    canBeUsed = false;
                    break;
                }
            }
            
            if(canBeUsed){
                result[index - 1] = flower;
                if(getSolution(index + 1, graph, n)){
                    return true;
                }
                result[index - 1] = 0;
            }
        }
        return false;
    }
}

// https://leetcode.com/problems/build-a-matrix-with-conditions/
// @author: anuj0503
class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Map<Integer, Set<Integer>> rowGraph = new HashMap<>();
        Map<Integer, Set<Integer>> colGraph = new HashMap<>();
        int[] inDegreeRow = new int[k+1];
        int[] inDegreeCol = new int[k+1];

        // Initalizing the map so that we dont have to check for null
        for(int i = 0; i <= k; i++) {
            rowGraph.put(i, new HashSet<>());
            colGraph.put(i, new HashSet<>());
        }

        // building a graph for row conditions along with populating the inDegree of each node.
        buildGraph(rowConditions, inDegreeRow, rowGraph);
        // building a graph for column conditions along with populating the inDegree of each node.
        buildGraph(colConditions, inDegreeCol, colGraph);

        // Finding Topological sort
        // or mapping of node/numbers to its position where it should be in row (index). 
        Map<Integer, Integer> rowTopoSort = getTopologicalSort(rowGraph, inDegreeRow, k);
        
        // Finding Topological sort
        // or mapping of node/numbers to its position where it should be in column (index). 
        Map<Integer, Integer> colTopoSort = getTopologicalSort(colGraph, inDegreeCol, k);

        // If we are not able to cover all nodes/numbers means there is cycle.
        if(rowTopoSort.size() != k || colTopoSort.size() != k) return new int[0][0];

        // Building tha metric usinbg the mapping we get from topological sort.
        return buildMatrix(k, rowTopoSort, colTopoSort);
    }

    private void buildGraph(int[][] conditions, int[] inDegree, Map<Integer, Set<Integer>> graph){
        for (int[] condition : conditions){
            int u = condition[0];
            int v = condition[1];

            Set<Integer> s = graph.get(u);
            s.add(v);
            graph.put(u, s);
        }

        for(int i = 1; i < inDegree.length; i++){
            for(int neighbour : graph.get(i)){
                inDegree[neighbour]++;
            }
        }
    }

    private Map<Integer, Integer> getTopologicalSort(Map<Integer, Set<Integer>> graph, int[] inDegree, int k){
        Map<Integer, Integer> numToPoistionMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= k; i++){
            if(inDegree[i] == 0) queue.offer(i);
        }

        int position = 0;
        while(!queue.isEmpty()){
            int head = queue.poll();
            numToPoistionMap.put(head, position++);

            for(int neighbour : graph.get(head)){
                inDegree[neighbour]--;

                if(inDegree[neighbour] == 0) queue.offer(neighbour);
            }
        }

        return numToPoistionMap;
    }

    private int[][] buildMatrix(int k, Map<Integer, Integer> rowMap, Map<Integer, Integer> colMap){
        int[][] matrix = new int[k][k];

        for(int i = 1 ; i <= k; i++){
            matrix[rowMap.get(i)][colMap.get(i)] = i;
        }

        return matrix;
    }
}

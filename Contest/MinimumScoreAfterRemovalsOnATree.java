// https://leetcode.com/contest/weekly-contest-299/problems/minimum-score-after-removals-on-a-tree/
// @author: anuj0503
class Solution {
    ArrayList[] graph;
    int ans;
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        int[] xorValues = new int[n];
        boolean[] visited = new boolean[n];
        graph = new ArrayList[n];
        ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        getXORSubTree(0, -1, xorValues, nums);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        
        while(!queue.isEmpty()){
            int v = queue.poll();
            
            for(int neighbour : (ArrayList<Integer>)graph[v]){
                if(!visited[neighbour]){
                    // System.out.println(neighbour);
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                    
                    // xorValue[u] will be our xor of first component.
                    int remainingXor = xorValues[0] ^ xorValues[neighbour];
                    
                    // Using DFS to find second component xor and third component xor
                    // and then comparing.
                    Calculate(v, neighbour, remainingXor, nums, xorValues[neighbour]);
                }
            }
        }
        
        return ans;
    }
    
    
    // Return XOR of subtree rooted at index u using DFS.
    private void getXORSubTree(int u, int v, int[] xorValues, int[] nums){
        xorValues[u] = nums[u];
        
        for(int neighbour : (ArrayList<Integer>)graph[u]){
            if(neighbour != v){
                getXORSubTree(neighbour, u, xorValues, nums);
                xorValues[u] ^= xorValues[neighbour];
            }
        }
    }
    
    private int Calculate(int u, int v, int remainingXor, int[] nums, int firstXORValue){
        int subTreeXor = nums[u];
        
        for(int neighbour : (ArrayList<Integer>)graph[u]){
            if(neighbour != v){
                int childXor = Calculate(neighbour, u, remainingXor, nums, firstXORValue);
                
                subTreeXor = subTreeXor ^ childXor;
                
                int secondXORValue = childXor;
                int thirdXORValue = remainingXor ^ secondXORValue;
                
                // System.out.println(firstXORValue + " " + secondXORValue + " " + thirdXORValue);
                ans = Math.min(ans, Math.max(Math.max(firstXORValue, secondXORValue), thirdXORValue) - Math.min(Math.min(firstXORValue, secondXORValue), thirdXORValue));
            }
        }
        
        return subTreeXor;
    }
}

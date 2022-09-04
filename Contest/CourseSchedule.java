// https://leetcode.com/problems/course-schedule/
// @author: anuj0503
class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] indegree = new int[n];
        
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0 ; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int[] p : prerequisites){
            int u = p[1];
            int v = p[0];
            
            indegree[v]++;
            
            graph[u].add(v);
        }
        
        for(int i = 0 ; i < n; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }
        
        while(!queue.isEmpty()){
            int head = queue.poll();
            
            if(indegree[head] == 0)
                set.add(head);
            
            for(int neighbor : graph[head]){
                indegree[neighbor]--;
                
                if(indegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }
        
        return set.size() == n;
    }
}

class Solution {
    bool  dfs(vector<int>&visited, int s, int d, vector<int>adj[],int node){
        
        visited[node] =1;
        if(node==d){
            return true;
        }
        
        for(auto num:adj[node]){
            
            if(!visited[num] && dfs(visited,s,d,adj,num)){
                return true;
            }
        }
        
        return false;
    }
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        vector<int>visited(n,0);
        
        vector<int>adj[n];
        
        for(int i=0;i<edges.size();i++){
            adj[edges[i][0]].push_back(edges[i][1]);
            adj[edges[i][1]].push_back(edges[i][0]);
        }
        
       return  dfs(visited, source, destination,adj,source);
    }
};
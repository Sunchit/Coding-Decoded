class Solution {
    void bfs(int node, vector<vector<pair<int, int>>> &adj, int &ans)
    {
        
        queue<int> q;
        vector<int> vis(adj.size(), 0);
        vis[node] = 1;
        q.push(node);
        
        while(!q.empty())
        {
            int x = q.front(); q.pop();
            
           for(auto &it: adj[x])
           {
               if(!vis[it.first])
               {
                   ans += it.second;
                   vis[it.first] = 1;
                   q.push(it.first);
               }
           }
        }
    }
public:
    int minReorder(int n, vector<vector<int>>& connections) {
        
        vector<vector<pair<int, int>>> adj(n);
        
        for(auto &it:connections)
        {
            adj[it[0]].push_back({it[1], 1});
            adj[it[1]].push_back({it[0], 0});
        }
        
        int ans = 0;
        bfs(0, adj, ans);
        return ans;
    }
};

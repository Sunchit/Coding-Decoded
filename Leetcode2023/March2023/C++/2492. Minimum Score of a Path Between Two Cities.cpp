class Solution {
    int bfs(vector<vector<pair<int, int>>> &adj, int n)
    {
        queue<int> q;
        vector<int> vis(n+1);
        vis[1] = 1;
        q.push(1);
        int ans = INT_MAX;
        
        while(!q.empty())
        {
            int node = q.front(); q.pop();
            
            for(auto &x:adj[node])
            {
                ans = min(ans, x.second);
                if(!vis[x.first])
                {
                    vis[x.first] = 1;
                    q.push(x.first);
                }
            }
        }
        return ans;
    }
public:
    int minScore(int n, vector<vector<int>>& roads) {
        
        vector<vector<pair<int, int>>> adj(n+1);
        for(auto &it: roads)
        {
            adj[it[0]].push_back({it[1], it[2]});
            adj[it[1]].push_back({it[0], it[2]});
        }
        return bfs(adj, n);
    }
};

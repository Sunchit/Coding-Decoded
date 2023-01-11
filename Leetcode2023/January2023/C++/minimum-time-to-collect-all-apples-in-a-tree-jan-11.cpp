class Solution {
    private:
    int dfs(int node, int parent, vector<int> adj[], vector<bool> &hasApple)
    {
        int total = 0, temp = 0;
        for(auto x:adj[node])
        {
            if(x!=parent)
            {
                temp = dfs(x,node,adj,hasApple);
                if(hasApple[x] or temp>0)
                    total += (temp+2); 
            }
        }
        return total;
    }
public:
    int minTime(int n, vector<vector<int>>& edges, vector<bool>& hasApple) {
        
        vector<int> adj[n];
        for(int i=0;i<edges.size();i++)
        {
            adj[edges[i][0]].push_back(edges[i][1]);
            adj[edges[i][1]].push_back(edges[i][0]);
        }
        
        return dfs(0,-1,adj,hasApple);
    }
};

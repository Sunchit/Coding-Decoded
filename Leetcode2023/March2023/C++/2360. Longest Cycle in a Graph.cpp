class Solution {
    private:
    void dfs(int node, vector<int> &edges, vector<int> &vis, vector<int> &dist,int distance, 
             vector<int> &ord, int &ans)
    {
        
        if(node!=-1)
        {
            if(!vis[node])
            { 
                dist[node] = distance;
                vis[node] = 1;
                ord[node] = 1;
                dfs(edges[node], edges, vis, dist, distance+1, ord, ans);
            }
            else if(ord[node])
            {
                ans = max(ans, distance-dist[node]);
            }
            ord[node] = 0;
        }
        

    }
public:
    int longestCycle(vector<int>& edges) {
        
        int n = edges.size();
        
        vector<int> ord(n,0),vis(n,0),dist(n,-1);
        int ans = -1;
        for(int i=0;i<n;i++)
        {
            if(i!=-1 and !vis[i])
                dfs(i,edges,vis,dist,0,ord,ans);
        }
        return ans;
    }
};

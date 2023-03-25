class Solution {
    private:
    void dfs(int i,vector<vector<int>> &g, long long &c, vector<int> &vis)
    {
        vis[i] = 1;
        c++;
        for(auto &it:g[i])
        {
            if(!vis[it]) dfs(it,g,c,vis);
        }
    }
public:
    long long countPairs(int n, vector<vector<int>>& edges) {
        
         vector<vector<int>> g(n);
        for(auto &it:edges)
        {
            g[it[0]].push_back(it[1]);
            g[it[1]].push_back(it[0]);

        }
        
        long long ans = 0;
        vector<int> vis(g.size(),0);
        for(int i=0;i<g.size();i++)
        {
            if(!vis[i])
            {
                long long c = 0;
                dfs(i,g,c,vis);
                ans += (n-c)*c; // Total unconnected n nodes 
                n -= c; // Subtracting c connected nodes from n as they already connected 
            }
        }
        return ans;
        
    }
};

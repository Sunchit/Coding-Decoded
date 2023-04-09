class Solution {
public:
    int largestPathValue(string colors, vector<vector<int>>& edges) {
        
        int n = colors.length();
        vector<vector<int>> adj(n);
        vector<int> indegree(n);
        
        for(auto &it:edges)
        {
            adj[it[0]].push_back(it[1]);
            indegree[it[1]]++;
        }
        
        vector<vector<int>> count(n, vector<int>(26, 0));
        queue<int> q;
        
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0) q.push(i);
        }
        
        int ans = 0, seen = 0;
        
        while(!q.empty())
        {
            int node = q.front(); q.pop();
            ans = max(ans, ++count[node][colors[node]-'a']);
            seen++;
            
            for(auto &x:adj[node])
            {
                for(int i=0;i<26;i++)
                {
                    count[x][i] = max(count[x][i], count[node][i]);
                }
                
                indegree[x]--;
                if(indegree[x]==0) q.push(x);
            }
        }
        return seen<n?-1:ans;
    }
};

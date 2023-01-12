class Solution {
    private:
    vector<int> dfs(int node, int parent, vector<vector<int>> &adj, string &labels)
    {
        vector<int> temp(26);
        for(auto &it: adj[node])
        {
            if(it!=parent)
            {
            
                vector<int>temp1 = dfs(it,node,adj,labels);
                for(int i=0;i<26;i++)
                    temp[i] += temp1[i];
            }
        }
        ans[node] = ++temp[labels[node]-'a'];
        return temp;
    }
public:
    vector<int> ans;
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        
        ans.resize(n);
        vector<vector<int>> adj(n);
        for(auto &it:edges)
        {
            adj[it[0]].push_back(it[1]);
            adj[it[1]].push_back(it[0]);
        }
        dfs(0,-1,adj,labels);
        return ans;
    }
};

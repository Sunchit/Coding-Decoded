class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        if(n<2) return {0};
        queue<int> leaves;
        vector<unordered_set<int>> adj(n,unordered_set<int>());
        for(auto& edge:edges)
        {
            adj[edge[0]].insert(edge[1]);
            adj[edge[1]].insert(edge[0]);
        }
        
        for(int i=0;i<adj.size();i++) if(adj[i].size()==1) leaves.push(i);
        
        while(n>2)
        {
            n-=leaves.size();
            int temp=leaves.size();
            while(temp--)
            {
                int leaf=leaves.front();
                leaves.pop();
                int node=*adj[leaf].begin();
                // cout<<leaf<<" "<<node<<endl;
                adj[node].erase(adj[node].find(leaf));
                if(adj[node].size()==1)
                    leaves.push(node);
                
            }
        }
        
        vector<int> res;
        while(leaves.size())
       {
            res.push_back(leaves.front());
            leaves.pop();
       }
        return res;
    }
};
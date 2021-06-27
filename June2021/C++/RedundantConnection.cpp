//author - Shree Lakshmi
// TC : O(n)
// SC : O(n)
class Solution {
public:
    vector<int> parent;
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        int n = edges.size();
        if(n==0)
            return {};
        parent.resize(n+1);
        for(int i=1; i<=n; i++)
            parent[i] =i;
        for(auto& e:edges){
            int f1 = find(e[0]);
            int f2 = find(e[1]);
            if(f1!=f2)
                parent[f2] = f1;
            else return e;
        }
        return {};

    }
    int find(int x){
        return parent[x]==x? x:find(parent[x]);
    }
};
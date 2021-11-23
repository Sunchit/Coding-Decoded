class UnionFind{
    public : 
    UnionFind(int n)
    {
        // cout<<n<<endl;
        parent=vector<int>(n);
        for(int i=0;i<n;i++)
            parent[i]=i;
        
    }
    
    void unify(int i,int j)
    {
        int abosoluteparenti=getParent(i);
        int absoluteparentj=getParent(j);
        
        if(abosoluteparenti!=absoluteparentj)
        {
            parent[abosoluteparenti]=absoluteparentj;
        }
    }
    
    int getParent(int i)
    {
        // cout<<i<<endl;
        if(parent[i]==i)
            return i;
        parent[i]=getParent(parent[i]);
        return parent[i];
    }
    private :vector<int> parent;
    
};

class Solution {
public:
    int largestComponentSize(vector<int>& nums) {
        int val = *max_element(begin(nums),end(nums));
        UnionFind uf( val + 1);
        
        for(auto& i:nums)
        {
            for(int j=2;j<=sqrt(i);j++)
            {
                if(!(i%j))
                {
                    uf.unify(i, j);
                    uf.unify(i,i/j);
                }
            }
        }
        unordered_map<int,int> dict;
        int res=0;
        for(auto& i:nums)
        {
            int temp=uf.getParent(i);
            res=max(res,++dict[temp]);
            
            // res=dict[temp]>dict[res]?temp:res;
                 
        }
        // for(auto& i:dict) cout<<i.first<<" "<<i.second<<endl;
        return res;
    }
};
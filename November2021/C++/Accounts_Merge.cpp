class Solution {
public:
    int find(vector<int>& union_find,int idx)
    {
        if(union_find[idx]!=idx)
            idx=find(union_find,union_find[idx]);
        return idx;
    }
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
        vector<int> union_find(accounts.size(),0);
        unordered_map<string,int> dict;
        for(int i=0;i<accounts.size();i++)
        {
            union_find[i]=i;
            for(int j=1;j<accounts[i].size();j++)
            {
                if(dict.find(accounts[i][j])!=dict.end())
                {
                    int root1=find(union_find,i);
                    int root2=find(union_find,dict[accounts[i][j]]);
                    union_find[root1]=root2;
                }
                else
                    dict[accounts[i][j]]=union_find[i];
            }
        }
        
     
        
        unordered_map<int,vector<string>> res_dict;
        for(auto i:dict)
        {
            int res=find(union_find,i.second);
            res_dict[res].push_back(i.first);
        }
        
        
        vector<vector<string>> fres;
        for(auto& i:res_dict)
        {
            vector<string> temp=i.second;
            sort(begin(temp),end(temp));
            temp.insert(temp.begin(),accounts[i.first][0]);
            fres.push_back(temp);
        }
        
        return fres;
    }
};
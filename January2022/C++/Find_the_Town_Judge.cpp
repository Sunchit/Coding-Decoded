class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        if(n==1 && !trust.size()) return 1;
        vector<int> judge(n+1,1);
        int res=-1;
        for(auto& i:trust)
        {
            res=res==i[0]?-1:res;
            int idx=i[1];
            if(judge[idx]>0)
            {
                judge[idx]++;
                res=judge[idx]==n?idx:res;
            }
            judge[i[0]]=-(abs(judge[i[0]]));
            
        }
       
        return res;
    }
};
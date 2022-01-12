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




//c++ code
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int>in(n+1,0);
        for(int i=0;i<trust.size();i++){
            in[trust[i][1]]++;
            in[trust[i][0]]--;
        }
        int ans = -1;
        for(int i=1;i<n+1;i++){
            if(in[i] == n-1){
                ans = i;
            }
        }
        return ans;
    }
};

//Contributed by Ankit Ghosh

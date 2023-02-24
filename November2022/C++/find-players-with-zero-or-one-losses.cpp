class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        
        map<int,int>matchesCount;
        
        int len = matches.size();
    
    vector<vector<int>>ans(2);
        
        for(int index = 0; index < len; index++){
            
            matchesCount[matches[index][0]]++;
            matchesCount[-matches[index][1]]++;
        }
    
    
    for(auto num:matchesCount){
        
        if(num.first<0 && num.second==1){
            ans[1].push_back(-num.first);
        }
        else if(num.first>0  && matchesCount[-num.first]==0){
                 ans[0].push_back(num.first);
        }
    }
    
    sort(ans[0].begin(),ans[0].end());
    sort(ans[1].begin(),ans[1].end());
    
    
    return ans;
    
    }
};
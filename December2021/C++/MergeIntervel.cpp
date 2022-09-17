class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& I) {
        sort(begin(I), end(I));
        vector<vector<int>> ans {I[0]};                        
        for(auto i : I)
            if(i[0] <= ans.back()[1])                          
                ans.back()[1] = max(ans.back()[1], i[1]);
            else                                               
                ans.push_back(i);
        return ans;
    }
};

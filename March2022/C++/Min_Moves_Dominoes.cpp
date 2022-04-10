class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        vector<int> top_count(7,0);
        vector<int> top_swaps(7,0);
        vector<int> bottom_count(7,0);
        vector<int> bottom_swaps(7,0);
       int n=tops.size();
        for(int i=0;i<n;i++)
        {
            top_count[tops[i]]++;
            bottom_swaps[tops[i]]++;
            if(bottoms[i]==tops[i])  top_swaps[tops[i]]--;
            bottom_count[bottoms[i]]++;
            top_swaps[bottoms[i]]++;
            if(bottoms[i]==tops[i]) bottom_swaps[bottoms[i]]--;
        }
        
        int res=INT_MAX;
        for(int i=1;i<7;i++)
        {
            if(top_count[i]+top_swaps[i]>=n) res=min(res,top_swaps[i]);
            if(bottom_count[i]+bottom_swaps[i]>=n) res=min(res,bottom_swaps[i]);
        }
        return res==INT_MAX?-1:res;
        
        
    }
};
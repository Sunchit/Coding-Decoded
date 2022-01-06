class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        vector<int> drive(1001,0);
        for(auto& trip:trips)
        {
            drive[trip[1]]+=trip[0];
            drive[trip[2]]+=(-trip[0]);
        }
        int w=0;
        for(int i=0;i<=1000;i++)
        {
            w+=drive[i];
            if(w>capacity) return false;
        }
        return true;
        
    }
};
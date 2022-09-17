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



//c++ code
class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int cap) {
        
        int last = -1;  //to find the last location
        for(auto it : trips){
            last = max(last,it[2]);
        }
        vector<int>high(last+1);
        for(auto it : trips){
            if(it[1]==0 or it[2] == 0)return false;
            high[it[1]]+=it[0];
            high[it[2]]-=it[0];
        }
        
        for(int i=1;i<=last;i++){
            high[i]+=high[i-1];
            if(high[i] > cap)
                return false;
        }
        return true;
    }
};

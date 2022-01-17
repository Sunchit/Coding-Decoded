class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        int dist=INT_MIN,res=0,prev=-1;
        for(int i=0;i<seats.size();i++)
        {
            if(seats[i])
            {
                dist=prev<0?i:max(dist,(i-prev)/2);
                prev=i;
            }
        }
        
        return max(dist,(int)(seats.size()-prev-1));
    }
};
class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        if(points.size()==1) return 1;
        sort(begin(points),end(points));
        int start=points[0][0],end=points[0][1],res=1;
        for(int i=1;i<points.size();i++)
        {
            if(points[i][0]<=end)
            {
                start=max(start,points[i][0]);
                end=min(end,points[i][1]);
            }
            else 
            {
                res++;
                start=points[i][0];
                end=points[i][1];
            }
        }
        return res;
        
    }
};
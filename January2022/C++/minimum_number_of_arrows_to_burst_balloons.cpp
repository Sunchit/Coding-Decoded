class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(),points.end());
        int r=points[0][1],ans=1;
        for(auto x : points)
            if(x[0]<=r)
                r=min(r,x[1]);
            else{
                ans++;
                r=x[1];
            }
        return ans;
    }
};

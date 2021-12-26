class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        priority_queue<pair<double,int>> res;
        double dist=0;
        for(int i=0;i<points.size();i++)
        {
            dist= pow((points[i][0]*points[i][0] + 
                      points[i][1]*points[i][1]),0.5);
            res.push({dist,i});
            
            while(res.size()>k)
                res.pop();
            // res.push({dist,i});
        }
        // while(res.size()>k) res.pop();
        vector<vector<int>> ans;
        while(res.size())
        {
            int idx=res.top().second;
            res.pop();
            ans.push_back(points[idx]);
            
        }
        return ans;
    }
};
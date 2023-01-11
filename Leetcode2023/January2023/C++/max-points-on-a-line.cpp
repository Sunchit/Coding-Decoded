class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        int ans = 0;
        
        for(int i=0;i<n;i++)
        {
            int samepoints = 1;
            unordered_map<double,int> m;
            for(int j=i+1;j<n;j++)
            {
                if(points[j][0] == points[i][0] and points[j][1] == points[i][1])
                {
                    samepoints++;
                }
                // else if(points[i][0] == points[j][0])
                // {
                //     m[INT_MAX]++;
                // }
                else 
                {
                    double slope = double(points[i][1]-points[j][1])/
                        double (points[i][0]-points[j][0]) ; 
                    m[slope%10000000]++;
                }
            }
                int maxi = 0;
                for(auto &it:m)
                {
                    if(it.second>maxi) maxi = it.second;
                }

                maxi += samepoints;
                ans = max(ans, maxi);
        }
        return ans;
    }
};

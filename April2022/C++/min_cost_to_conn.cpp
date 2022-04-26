//Problem Link : https://leetcode.com/problems/min-cost-to-connect-all-points/
class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n = points.size();

        
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
        pq.push({0,0});
        // here first element of pair is taken as for storing distance because it can save us from writing custom comparing function of our own 
        bool visited[n];
        int ans = 0;
        memset(visited,false,n);
        int vcnt = 0;
        while(pq.size() > 0 && vcnt < n){
            pair edge = pq.top(); pq.pop();
            if(visited[edge.second]  == true)
                continue;
            visited[edge.second]  = true;
            vcnt++;
            
            ans += edge.first;
           
            for(int i = 0; i < n; i++){
                if(visited[i] == false){
                     int mhd = abs(points[edge.second][0] - points[i][0]) + abs(points[edge.second][1] - points[i][1]);
                    pq.push({mhd,i});
                }
            }
             
        }
        return ans;
        
        
    }
};

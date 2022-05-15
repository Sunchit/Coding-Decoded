// Problem Link : https://leetcode.com/problems/network-delay-time/
class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        
        vector<pair<int,int>> graph[n+1];
        int td = times.size();
        for(int i=0; i <td; i++){
          // we are taking time in first part of pair because this will help us in Priority queue for arrangement according to least time 
            graph[times[i][0]].push_back({times[i][2],times[i][1]});
        }
        int dist[n+1];
        // memset(dist,INT_MAX,sizeof(dist));
         for(int i=1;i<=n;i++)
            dist[i] = INT_MAX;
        dist[0] = -1;
        dist[k] = 0;
       
        
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
        pq.push({0,k});
        while(pq.size()){
            pair<int,int> x = pq.top();pq.pop();
            
            for( pair<int,int> itr : graph[x.second]){
                
                if(x.first + itr.first < dist[itr.second]){
                    dist[itr.second] = x.first + itr.first;
                    pq.push({x.first + itr.first, itr.second});
                }
                
            }
        }
        int ans = 0;
        for(int i=1;i<=n;i++){
               // cout <<dist[i]; 
            if(dist[i] == INT_MAX)
                return -1;
            else if(ans < dist[i])
                ans = dist[i];
        }
        return ans;
    }
};

//Problem Link : https://leetcode.com/problems/path-with-minimum-effort/

class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        int row = heights.size();
        int col = heights[0].size();
        
        int dis[row][col];
       
        for(int i=0;i<row;i++)
            for(int j = 0;j < col;j++)
                dis[i][j] = INT_MAX;
        
        priority_queue<vector<int>,vector<vector<int>>,greater<vector<int>>> pq;
        
        pq.push({0,0,0});
        dis[0][0] = 0;
        int tarr[] = {0,1,0,-1,0};
        while(pq.size() ){
            // cout<<pq.size()<<"@"<<endl;
            vector<int> temp = pq.top();pq.pop();
            int currEffort = temp[0];
            int currX = temp[1];
            int currY = temp[2];
            
            if(currX == row -1 && currY == col - 1)
                return currEffort;
            
            for(int i = 0; i < 4; i++ ){
                int newX = currX + tarr[i];
                int newY = currY + tarr[i + 1];
                
                if(newX>=0 && newX < row && newY>=0 && newY <col){
                    int newEffort = max(currEffort,abs(heights[newX][newY] - heights[currX][currY]));
                    if(newEffort < dis[newX][newY]){
                        // cout<<newEffort<<endl;
                        dis[newX][newY] = newEffort;
                        pq.push({newEffort, newX, newY});
                    }
                }
            }
            
            
        }
        return 0;
    }
};

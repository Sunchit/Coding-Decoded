class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& grid) {
        vector<vector<int>> visited(100,vector<int>(100,-1));
        return dfs(grid,visited,0,0);
    }

    int dfs(vector<vector<int>>& grid,vector<vector<int>>& visited,int i,int j){
        if(i==grid.size() || j==grid[0].size() || grid[i][j]==1) return 0;
        if(i==grid.size()-1 && j==grid[0].size()-1) return 1; 
        if(visited[i][j]!=-1) return visited[i][j];
        visited[i][j]=dfs(grid,visited,i,j+1)+dfs(grid,visited,i+1,j);
        return visited[i][j];
    }
};
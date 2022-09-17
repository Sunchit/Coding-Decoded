class Solution {
    private:
    int dfs(vector<vector<int>>& grid, int &area, int i, int j)
    {
        int n = grid.size();
        int m = grid[0].size();
        
        if(i>=n or j>=m or i<0 or j<0 or grid[i][j]==0) return 0;
        
        area++;
        grid[i][j] = 0;
        
        dfs(grid,area,i+1,j);
        dfs(grid,area,i-1,j);
        dfs(grid,area,i,j+1);
        dfs(grid,area,i,j-1);
        return area;
    }
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    int area = 0;
                    int area1 = dfs(grid,area,i,j);
                    ans = max(ans,area1);
                }
            }
        }
        return ans;
    }
};

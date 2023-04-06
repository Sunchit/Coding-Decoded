class Solution {
    void dfs(int i, int j, vector<vector<int>>& grid)
    {
        grid[i][j] = 1;
        int n = grid.size(), m = grid[0].size();
        
        int dx[] = {0, 0, -1, 1};
        int dy[] = {1, -1, 0, 0};
        
        for(int k=0;k<4;k++)a
        {
            int nx = i+dx[k];
            int ny = j+dy[k];

            if(nx>=0 and ny>=0 and nx<n and ny<m and grid[nx][ny]==0) 
                dfs(nx, ny, grid);
        }

    }
public:
    int closedIsland(vector<vector<int>>& grid) {
        
        int n = grid.size(), m = grid[0].size();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i*j==0 or i==n-1 or j==m-1)
                {
                    if(grid[i][j]==0) dfs(i, j, grid);
                }
            }
        }
        
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0) {ans++; dfs(i, j, grid);}
            }
        }
        return ans;
    }
};

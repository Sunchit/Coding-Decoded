class Solution {
    void dfs(int i, int j, vector<vector<int>>& grid, int n, int m)
    {
        grid[i][j] = 0;
        
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        
        for(int k=0;k<4;k++)
        {
            int nx = i+dx[k];
            int ny = j+dy[k];
            
            if(nx>=0 and ny>=0 and nx<n and ny<m and grid[nx][ny]) 
                dfs(nx, ny, grid, n, m);
        }
    }
public:
    int numEnclaves(vector<vector<int>>& grid) {
        
        int n = grid.size(), m = grid[0].size();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if( (i*j==0 or i==n-1 or j==m-1) and grid[i][j]) 
                dfs(i, j, grid, n, m); 
            }
        }
        
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]) ans++;
            }
            cout<<endl;
        }
        return ans;
    }
};

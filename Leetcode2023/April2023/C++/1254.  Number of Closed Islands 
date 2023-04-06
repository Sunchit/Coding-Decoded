class Solution {
public:
    int closedIsland(vector<vector<int>>& grid) {
        int m = grid.size(),n=grid[0].size();
        vector<vector<bool>> visited(m,vector<bool>(n,false));
        vector<vector<int>> valid(m,vector<int>(n,-1));
        
        int res =0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!visited[i][j] && grid[i][j]==0)
                {
                    res+=dfs(visited,grid,valid,i,j)?1:0;
                }
            }
        }

        return res;
    }

    bool dfs(vector<vector<bool>>& visited,vector<vector<int>>& grid,vector<vector<int>>& valid,int i,int j)
    {
        if(i<0 || j<0 || i==grid.size() || j==grid[0].size()) return false;
        if(visited[i][j] || grid[i][j]==1) return true;

        visited[i][j]=true;
        bool r = dfs(visited,grid,valid,i,j+1);
        bool l = dfs(visited,grid,valid,i,j-1);
        bool u = dfs(visited,grid,valid,i-1,j);
        bool d = dfs(visited,grid,valid,i+1,j);

        valid[i][j] =  l && r && u && d?1:0;
        return valid[i][j];

    }
};
/**
 * @author ssrbazpur
 * Time Complexity: O(M*N)
 * Space COmplexity:O(M*N)
 */

class Solution
{
public:
    void dfs(vector<vector<int>> &grid, int row, int col, int &ans)
    {

        if (row < 0 || row > grid.size() - 1 || col < 0 || col > grid[0].size() - 1)
        {
            return;
        }

        if (grid[row][col] == 0)
        {
            return;
        }
        if (grid[row][col] == 1)
        {
            grid[row][col] = 0;
            ans = ans + 1;
        }

        dfs(grid, row + 1, col, ans);
        dfs(grid, row - 1, col, ans);
        dfs(grid, row, col - 1, ans);
        dfs(grid, row, col + 1, ans);
    }
    int maxAreaOfIsland(vector<vector<int>> &grid)
    {

        int ans = 0;
        int result = 0;
        for (int i = 0; i < grid.size(); i++)
        {
            for (int j = 0; j < grid[i].size(); j++)
            {
                ans = 0;
                if (grid[i][j] == 1)
                {

                    dfs(grid, i, j, ans);
                }
                result = max(result, ans);
            }
        }

        return result;
    }
};
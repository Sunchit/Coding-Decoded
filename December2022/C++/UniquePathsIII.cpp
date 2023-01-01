// https://leetcode.com/problems/unique-paths-iii/
class Solution {
private:
    int helper(int x, int y, int count, int& nonObstacles, vector<vector<int>>& grid, vector<vector<int>>& vis, vector<int>& dx, vector<int>& dy, int& m, int& n) {
        // base case
        if (grid[x][y] == 2) {
            if (count == nonObstacles) {
                return 1;
            }
            return 0;
        }
        
        int sum = 0;
        vis[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (isValid(newX, newY, grid, vis, m, n)) {
                sum += helper(newX, newY, count + 1, nonObstacles, grid, vis, dx, dy, m, n);
            }
        }
        vis[x][y] = 0;
        return sum;
    }
    
    bool isValid(int x, int y, vector<vector<int>>& grid, vector<vector<int>>& vis, int& m, int& n) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != -1 && vis[x][y] == 0;
    }
    
public:
    // TC: O(4^(m * n))
    // SC: O(m * n) + O(m * n)
    int uniquePathsIII(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int nonObstacles = 0;
        int startX = -1;
        int startY = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 1) {
                    nonObstacles++;
                }
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        vector<vector<int>> vis(m, vector<int>(n, 0));
        vector<int> dx{0, 1, 0, -1};
        vector<int> dy{1, 0, -1, 0};
        
        return helper(startX, startY, 0, nonObstacles, grid, vis, dx, dy, m, n);
    }
};

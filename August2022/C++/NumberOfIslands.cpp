// https://leetcode.com/problems/number-of-islands/

// DFS Solution
// TC: O(m * n) + O(m * n * 4)  => nested loops + DFS of the matrix
// SC: O(m * n) + O(m * n)      => visited array + auxiliary stack space
class Solution {
private:
    void dfs(int row, int col, vector<vector<char>>& grid, vector<vector<int>>& vis, int dx[], int dy[]) {
        vis[row][col] = 1;
        
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            
            if (isValid(newRow, newCol, grid, vis)) {
                dfs(newRow, newCol, grid, vis, dx, dy);
            }
        }
    }
    
    bool isValid(int row, int col, vector<vector<char>>& grid, vector<vector<int>>& vis) {
        int m = grid.size();
        int n = grid[0].size();
        return row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == '1' && vis[row][col] == 0;
    }
    
public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        
        vector<vector<int>> vis(m, vector<int>(n, 0));
        int count = 0;
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    dfs(i, j, grid, vis, dx, dy);
                    count++;
                }
            }
        }
        
        return count;
    }
};


// BFS Solution
// TC: O(m * n) + O(m * n * 4)  => nested loops + BFS of the matrix
// SC: O(m * n) + O(m * n)      => visited array + queue 
class Solution {
private:
    void bfs(int row, int col, vector<vector<char>>& grid, vector<vector<int>>& vis, int dx[], int dy[]) {
        queue<pair<int, int>> queue;
        
        queue.push({row, col});
        vis[row][col] = 1;
        
        while (!queue.empty()) {
            row = queue.front().first;
            col = queue.front().second;
            queue.pop();
            
            for (int i = 0; i < 4; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];
                if (isValid(newRow, newCol, grid, vis)) {
                    queue.push({newRow, newCol});
                    vis[newRow][newCol] = 1;
                }
            }
        }
    }
    
    bool isValid(int row, int col, vector<vector<char>>& grid, vector<vector<int>>& vis) {
        int m = grid.size();
        int n = grid[0].size();
        return row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == '1' && vis[row][col] == 0;
    }
    
public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        
        vector<vector<int>> vis(m, vector<int>(n, 0));
        int count = 0;
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    bfs(i, j, grid, vis, dx, dy);
                    count++;
                }
            }
        }
        
        return count;
    }
};

// https://leetcode.com/problems/pacific-atlantic-water-flow

// DFS Solution
// TC: O(m * n)
// SC: O(m * n)
class Solution {
private:
    void dfs(int row, int col, vector<vector<int>>& heights, vector<vector<int>>& vis, int dx[], int dy[]) {
        vis[row][col] = 1;
        
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            
            if (isValid(newRow, newCol, vis) && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, heights, vis, dx, dy);
            }
        }
    }
    
    bool isValid(int row, int col, vector<vector<int>>& vis) {
        int m = vis.size();
        int n = vis[0].size();
        return row >= 0 && row < m && col >= 0 && col < n && vis[row][col] == 0;
    }
    
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int m = heights.size();
        int n = heights[0].size();
        
        vector<vector<int>> pacific(m, vector<int>(n, 0));
        vector<vector<int>> atlantic(m, vector<int>(n, 0));
        
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        
        for (int j = 0; j < n; j++) {
            if (!pacific[0][j]) {
                dfs(0, j, heights, pacific, dx, dy);
            }
            if (!atlantic[m - 1][j]) {
                dfs(m - 1, j, heights, atlantic, dx, dy);
            }
        }
        
        for (int i = 0; i < m; i++) {
            if (!pacific[i][0]) {
                dfs(i, 0, heights, pacific, dx, dy);
            }
            if (!atlantic[i][n - 1]) {
                dfs(i, n - 1, heights, atlantic, dx, dy);
            }
        }
        
        vector<vector<int>> ans;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    ans.push_back({i, j});
                }
            }
        }
        
        return ans;
    }
};



// BFS Solution
// TC: O(m * n)
// SC: O(m * n)
class Solution {
private:
    void bfs(int row, int col, vector<vector<int>>& heights, vector<vector<int>>& vis, int dx[], int dy[]) {
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

                if (isValid(newRow, newCol, vis) && heights[newRow][newCol] >= heights[row][col]) {
                    queue.push({newRow, newCol});
                    vis[newRow][newCol] = 1;
                }
            }
        }
    } 
    
    bool isValid(int row, int col, vector<vector<int>>& vis) {
        int m = vis.size();
        int n = vis[0].size();
        return row >= 0 && row < m && col >= 0 && col < n && vis[row][col] == 0;
    }
    
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int m = heights.size();
        int n = heights[0].size();
        
        vector<vector<int>> pacific(m, vector<int>(n, 0));
        vector<vector<int>> atlantic(m, vector<int>(n, 0));
        
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        
        for (int j = 0; j < n; j++) {
            if (!pacific[0][j]) {
                bfs(0, j, heights, pacific, dx, dy);
            }
            if (!atlantic[m - 1][j]) {
                bfs(m - 1, j, heights, atlantic, dx, dy);
            }
        }
        
        for (int i = 0; i < m; i++) {
            if (!pacific[i][0]) {
                bfs(i, 0, heights, pacific, dx, dy);
            }
            if (!atlantic[i][n - 1]) {
                bfs(i, n - 1, heights, atlantic, dx, dy);
            }
        }
        
        vector<vector<int>> ans;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    ans.push_back({i, j});
                }
            }
        }
        
        return ans;
    }
};

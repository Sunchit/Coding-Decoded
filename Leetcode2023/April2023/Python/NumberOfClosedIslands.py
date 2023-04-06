class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        vis = [[False for j in range(n)] for i in range(m)]
        dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]

        for i in range(m):
            if grid[i][0] == 0 and not vis[i][0]:
                self.dfs(i, 0, grid, vis, dx, dy)
            if grid[i][n - 1] == 0 and not vis[i][n - 1]:
                self.dfs(i, n - 1, grid, vis, dx, dy)

        for j in range(n):
            if grid[0][j] == 0 and not vis[0][j]:
                self.dfs(0, j, grid, vis, dx, dy)
            if grid[m - 1][j] == 0 and not vis[m - 1][j]:
                self.dfs(m - 1, j, grid, vis, dx, dy)

        count = 0
        for i in range(1, m - 1):
            for j in range(1, n - 1):
                if grid[i][j] == 0 and not vis[i][j]:
                    self.dfs(i, j, grid, vis, dx, dy)
                    count += 1

        return count

    def dfs(self, row, col, grid, vis, dx, dy):
        vis[row][col] = True

        for i in range(4):
            newRow = row + dx[i]
            newCol = col + dy[i]
            if self.isValid(newRow, newCol, grid, vis):
                self.dfs(newRow, newCol, grid, vis, dx, dy)

    def isValid(self, row, col, grid, vis):
        m, n = len(grid), len(grid[0])
        return row >= 0 and row < m and col >= 0 and col < n and grid[row][col] == 0 and not vis[row][col]

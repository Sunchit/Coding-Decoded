class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:        
        m = len(grid)
        n = len(grid[0])

        vis = [[False for j in range(n)] for i in range(m)]

        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]

        for i in range(m):
            if grid[i][0] == 1 and not vis[i][0]:
                self.dfs(i, 0, grid, vis, dx, dy)

            if grid[i][n - 1] == 1 and not vis[i][n - 1]:
                self.dfs(i, n - 1, grid, vis, dx, dy)

        for j in range(n):
            if grid[0][j] == 1 and not vis[0][j]:
                self.dfs(0, j, grid, vis, dx, dy)

            if grid[m - 1][j] == 1 and not vis[m - 1][j]:
                self.dfs(m - 1, j, grid, vis, dx, dy)

        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1 and not vis[i][j]:
                    count += 1

        return count

    def dfs(self, row: int, col:int, grid: List[List[int]], vis: List[List[bool]], dx: List[int], dy: List[int]) -> None:

        vis[row][col] = True

        for i in range(4):
            newRow = row + dx[i]
            newCol = col + dy[i]

            if self.isValid(newRow, newCol, grid, vis):
                self.dfs(newRow, newCol, grid, vis, dx, dy)

    def isValid(self, row:int, col:int, grid: List[List[int]], vis: List[List[bool]]) -> bool:
        m = len(grid)
        n = len(grid[0])

        return row >= 0 and row < m and col >= 0 and col < n and grid[row][col] == 1 and not vis[row][col]


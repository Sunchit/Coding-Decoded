class Solution {
	// TC : O(n*m*(m+n))
	// SC: O(n*m* (m+n))
	public boolean hasValidPath(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		// i, j , bal
		Boolean[][][] visited = new Boolean[m][n][m + n];
		return dfs(grid, 0, 0, 0, visited);
	}

	private boolean dfs(char[][] grid, int i, int j, int bal, Boolean[][][] visited) {
		int m = grid.length, n = grid[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n || bal < 0) return false;

		if (visited[i][j][bal] != null) return visited[i][j][bal];

		int updatedBal = bal + (grid[i][j] == '(' ? 1 : -1);

		if (i == m - 1 && j == n - 1 && updatedBal == 0) return true;


		boolean valid = dfs(grid, i + 1, j, updatedBal, visited) || dfs(grid, i, j + 1, updatedBal, visited);

		visited[i][j][bal] = valid;
		return valid;
	}
}
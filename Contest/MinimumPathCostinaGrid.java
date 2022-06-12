class Solution {

	// TC : O(n2*m)
	// SC O(n*m)
	public int minPathCost(int[][] grid, int[][] moveCost) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] cost = new int[m][n];
		// Set cost for the Row 0
		for (int c = 0; c < n; ++c) {
			cost[0][c] = grid[0][c];
		}

		// From First row till the last
		for (int r = 1; r < m; r++) {
			for (int c = 0; c < n; c++) {

				int minCostFromPeviousRow = Integer.MAX_VALUE;

				for (int j = 0; j < n; j++) {
					// Min (Mi+Ci)
					minCostFromPeviousRow = Math.min(minCostFromPeviousRow, cost[r - 1][j] + moveCost[grid[r - 1][j]][c]);
				}

				cost[r][c] = minCostFromPeviousRow + grid[r][c];
			}
		}

		int leastCostInLastRow = Integer.MAX_VALUE;

		for(int el: cost[m-1]){
			leastCostInLastRow = Math.min(leastCostInLastRow, el);
		}
		return leastCostInLastRow;
	}
}
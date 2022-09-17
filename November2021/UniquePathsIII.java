class Solution {
	public int uniquePathsIII(int[][] grid) {
		int zero = 0; // Count the 0's
		int sx = 0; // starting x index
		int sy = 0; // starting y index

		for(int r = 0; r < grid.length; r++){ // r = row
			for(int c = 0; c < grid[0].length; c++){ // c = column
				if(grid[r][c] == 0) zero++; // if current cell is 0, count it.
				else if(grid[r][c] == 1){
					sx = r; // starting x co-ordinate
					sy = c; // starting y co-ordinate
				}
			}
		}
		return dfs(grid, sx, sy, zero);
	}
	public int dfs(int grid[][], int x, int y, int zero){
		// Base Condition
		if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1){
			return 0;
		}
		if(grid[x][y] == 2){
			return zero == -1 ? 1 : 0; // Why zero = -1, because in above example we have 9 zero's. So, when we reach the final cell we are covering one cell extra then the zero count.
			// If that's the case we find the path and return '1' otherwise return '0';
		}
		grid[x][y] = -1; // mark the visited cells as -1;
		zero--; // and reduce the zero by 1

		int totalPaths = dfs(grid, x + 1, y, zero) + // calculating all the paths available in 4 directions
						dfs(grid, x - 1, y, zero) +
						dfs(grid, x, y + 1, zero) +
						dfs(grid, x, y - 1, zero);

		// Let's say if we are not able to count all the paths. Now we use Backtracking over here
		grid[x][y] = 0;
		zero++;

		return totalPaths; // if we get all the paths, simply return it.
	}
}
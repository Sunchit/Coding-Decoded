class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {

		int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
		for (int[] row: dp) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		// start from the top of the triangle to the bootttom
		return recurse(triangle, 0, 0, dp);
	}

	private int recurse(List<List<Integer>> triangle, int row, int col, int[][] dp) {

		if (row == triangle.size()) {
			return 0;
		}


		if (dp[row][col] != Integer.MAX_VALUE) {
			return dp[row][col];
		}

		// either go to [row + 1, col] or [row + 1, col + 1]
		int minimum = Math.min(recurse(triangle, row + 1, col, dp),
		                       recurse(triangle, row + 1, col + 1, dp));

		// combine answer with current value
		dp[row][col] = triangle.get(row).get(col) + minimum;
		return dp[row][col];
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int[] dp = new int[triangle.size()+1];

		for(int i=triangle.size()-1;i>=0;i--){

			for(int j=0;j<triangle.get(i).size();j++){
				dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
			}
		}


		return dp[0];
	}
}


// @saorav21994
// TC : O(n^2)
// SC : O(n^2)

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int[n+1][n+1];
        
        // bottom-up
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        
        return dp[0][0];
    }
}

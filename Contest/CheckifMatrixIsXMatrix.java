class Solution {
	// TC : O(n2)

	public boolean checkXMatrix(int[][] grid) {

		int n = grid.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(isDiagonal(i,j, n)){
					if(grid[i][j]==0){
						return false;
					}
				} else {
					if(grid[i][j]!=0){
						return false;
					}
				}
			}
		}

		return true;
	}

	private boolean isDiagonal(int i, int j, int n){
		return (i==j) || (i+j==n-1);
	}
}
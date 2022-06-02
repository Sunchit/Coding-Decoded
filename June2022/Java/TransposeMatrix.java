class Solution {

	// TC : O(m*n)
	public int[][] transpose(int[][] matrix) {
		int n = matrix.length;
		if(n==0){
			return matrix;
		}

		int m = matrix[0].length;
		if(m==0){
			return matrix;
		}

		int[][] transpose = new int[m][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				j,i <->i,j
				transpose[j][i] = matrix[i][j];
			}
		}

		return transpose;
	}
}


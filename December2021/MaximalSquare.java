// TC : O(n*m)
// SC. : O(n*m)

class Solution {
	public int maximalSquare(char[][] matrix) {
		if(matrix.length ==0 || matrix[0].length == 0){
			return 0;
		}
		int[][] dp = new int[matrix.length+1][matrix[0].length+1];
		int ans = 0; // sqaure length
		for(int i=1;i<=matrix.length;i++){

			for(int j=1;j<=matrix[0].length;j++) {
				if(matrix[i-1][j-1] == '1') {
					int min = Integer.MAX_VALUE;
					min = Math.min(dp[i-1][j], min);
					min = Math.min(dp[i][j-1], min);
					min = Math.min(dp[i-1][j-1], min);

					dp[i][j] = min+1;
					ans = Math.max(dp[i][j], ans);
				}
			}
		}

//          for(int i=0;i<=matrix.length;i++){

//             for(int j=0;j<=matrix[0].length;j++) {
//                     System.out.print(dp[i][j] + " ");
//                 }
//              System.out.println();
//             }

		return ans * ans;

	}
}

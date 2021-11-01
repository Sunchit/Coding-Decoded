class Solution {
	private class Point {
		private int x;
		private int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}


	}
	public void solve(char[][] board) {
		if(board.length==0 || board[0].length==0){
			return ;
		}
		int n = board.length;
		int m = board[0].length;

		// first column
		for(int i=0;i<n;i++){
			if(board[i][0] =='O'){
				dfs(board, i, 0);
			}

		}

		// last column
		for(int i=0;i<n;i++){
			if(board[i][m-1] =='O'){
				dfs(board, i, m-1);
			}

		}

		// first row
		for(int i=0;i<m;i++){
			if(board[0][i] =='O'){
				dfs(board, 0,i);
			}

		}

		// last row
		for(int i=0;i<m;i++){
			if(board[n-1][i] =='O'){
				dfs(board, n-1,i);
			}

		}


		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(board[i][j] =='O'){
					board[i][j] = 'X';
				}
			}

		}


		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(board[i][j] =='V'){
					board[i][j] = 'O';
				}
			}
		}

	}


	private void dfs(char[][] baord, int i , int j){
		if(i<0 || j<0 || i>=baord.length || j>=baord[0].length || (baord[i][j] == 'V') || (baord[i][j] == 'X')){
			return ;
		}
		else {
			baord[i][j] = 'V';
			dfs(baord, i-1, j);

			dfs(baord, i+1, j);

			dfs(baord, i, j-1);

			dfs(baord, i, j+1);

		}

	}

}
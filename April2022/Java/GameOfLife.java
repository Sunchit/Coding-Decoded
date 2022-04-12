
// @saorav21994
// TC : O(n^2)
// SC : O(1)

class Solution {
    
    // 1 -> live, 3 -> present 0 (dead) will become 1 (live) in next 
    // 0 -> dead, 2 -> present 1 (live) will become 0 (dead) in next 
    
    int m = 0, n = 0;
    
    public boolean validInd(int i, int j) {
        if (i >= 0 && i < m && j >= 0 && j < n) return true;
        return  false;
    }
    
    public void checkNeighbour(int [][]board, int i, int j) {
        int live = 0, dead = 0;
        if (validInd(i-1, j-1)) {
            if (board[i-1][j-1] == 1 || board[i-1][j-1] == 2) {
                live += 1;
            }
            else dead += 1;
        }
        if (validInd(i-1, j)) {
            if (board[i-1][j] == 1 || board[i-1][j] == 2) {
                live += 1;
            }
            else dead += 1;
        }
        if (validInd(i-1, j+1)) {
            if (board[i-1][j+1] == 1 || board[i-1][j+1] == 2) {
                live += 1;
            }
            else dead += 1;
        }
        if (validInd(i, j-1)) {
            if (board[i][j-1] == 1 || board[i][j-1] == 2) {
                live += 1;
            }
            else dead += 1;
        }
        if (validInd(i, j+1)) {
            if (board[i][j+1] == 1 || board[i][j+1] == 2) {
                live += 1;
            }
            else dead += 1;
        }
        if (validInd(i+1, j-1)) {
            if (board[i+1][j-1] == 1 || board[i+1][j-1] == 2) {
                live += 1;
            }
            else dead += 1;
        }
        if (validInd(i+1, j)) {
            if (board[i+1][j] == 1 || board[i+1][j] == 2) {
                live += 1;
            }
            else dead += 1;
        }
        if (validInd(i+1, j+1)) {
            if (board[i+1][j+1] == 1 || board[i+1][j+1] == 2) {
                live += 1;
            }
            else dead += 1;
        }
        
        if (board[i][j] == 1) {
            if (live < 2 || live > 3) board[i][j] = 2;
        }
        else {
            if (live == 3) board[i][j] = 3;
        }
        
        return;
    }
    
    public void gameOfLife(int[][] board) {
        
        if (board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
               checkNeighbour(board, r, c); 
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) board[i][j] = 0;
                else if (board[i][j] == 3) board[i][j] = 1;
            }
        }
    }
}


class Solution {
	// TC : O(n*m)
	// SC : O(1)
	private int[][] directions = new int[][]{{0,1}, {1,0}, {-1, 0}, {0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};

	public void gameOfLife(int[][] board) {
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j] == 1){
					int activeNeigh = getActiveNeigh(board, i,j);
					if(activeNeigh <2 || activeNeigh >3){
						board[i][j] =-2; // 0
					}
				} else if(board[i][j] ==0){
					int activeNeigh = getActiveNeigh(board, i,j);
					if(activeNeigh == 3){
						board[i][j] = -1; // will become active in next state
					}
				}
			}
		}
		updateBoard(board);
		return;
	}

	private void updateBoard(int[][] board){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j] ==-2){
					board[i][j] = 0;
				}
				if(board[i][j] ==-1){
					board[i][j] = 1;
				}
			}
		}
	}

	private int getActiveNeigh(int[][] board, int row, int col){
		int activeNeigh = 0;
		for(int[] direction : directions){
			int newRow = row + direction[0];
			int newCol = col + direction[1];

			if(newRow >=0 && newRow<board.length && newCol>=0 && newCol<board[0].length && (board[newRow][newCol] ==1 || board[newRow][newCol] == -2)){
				activeNeigh++;
			}
		}
		return activeNeigh;
	}
}
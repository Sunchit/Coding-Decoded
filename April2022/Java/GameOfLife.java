
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

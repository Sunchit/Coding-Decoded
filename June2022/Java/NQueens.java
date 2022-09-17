
// @saorav21994
// TC : O(n!)
// SC : O(n*n)
// simple backtrack

class Solution {
    
    List<List<String>> res;
    
    public List<List<String>> solveNQueens(int n) {
        
        res = new ArrayList<>();
        
        boolean [][] board = new boolean[n][n];     // default false -> empty
        backtrack(board, 0/*start index*/);
        
        return res;
        
    }
    
    public void backtrack(boolean [][] board, int idx) {
        
        if (idx == board.length) {      // valid config found
            
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                char [] ch = new char[board.length];
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == true /*queen present*/) {
                        ch[j] = 'Q';
                    }
                    else {
                        ch[j] = '.';
                    }
                }
                tmp.add(new String(ch));
            }
            res.add(tmp);
            return;        
        }
        
        // for each row from idx....board.length
        for (int i = 0; i < board.length; i++) {

            if (validPos(board, idx, i)) {
                // set queen
                board[idx][i] = true;
                // recursively call backtrack
                backtrack(board, idx+1);
                // revert set to queen
                board[idx][i] = false;
            }
        }
        
        return;
        
    }
    
    public boolean validPos(boolean [][] board, int r, int c) {
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                
                if (board[i][j] == true /*has queen*/ && 
                   ((i-j) == (r-c) /*primary diagonal*/ || (i+j) == (r+c) /*secondary diagonal*/ ||
                   j == c /*lies in same column*/)) {
                    return false;       // queen threatened
                }
                
            }
        }
        
        return true;
    }
    
}

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();


        char[][] chess = new char[n][n];
        // . stands for empty position
        // Q stands for occupied position
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }

        placeQueens(ans, chess, 0);
        return ans;
    }


    private void placeQueens(List<List<String>> ans, char[][] chess, int row) {
        if (row == chess.length) {
            ans.add(build(chess));
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            // Check if current position is valid
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                placeQueens(ans, chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }

    private boolean valid(char[][] chess, int row, int col) {
        // check all rows for the current column
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        //check for 45 degree positions
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //check for 135 positions
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> build(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }
}

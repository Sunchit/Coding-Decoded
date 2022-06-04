
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

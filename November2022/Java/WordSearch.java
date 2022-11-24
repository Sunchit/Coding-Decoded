// @saorav21994

class Solution {
    public boolean exist(char[][] board, String word) {
        // char [] ch = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    // System.out.println("character match in main loop. i = " + i + " j = " + j);
                    if (checkWord(board, i, j, 0, word)) {
                        // System.out.println("found true");
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean checkWord(char [][] board, int i, int j, int start, String wArray) {
        
        // System.out.println("Start = " + start);
        if (start == wArray.length()) {
            // System.out.println("start == wArray.length");
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || board[i][j] != wArray.charAt(start)) {
            // System.out.println("Big consition mismatch");
            return false;
        }
        char ch = board[i][j];
        board[i][j] = '#';  // mark as visited
        boolean res = false;
        res = (checkWord(board, i-1, j, start+1, wArray) || checkWord(board, i, j-1, start+1, wArray) || checkWord(board, i+1, j, start+1, wArray) || checkWord(board, i, j+1, start+1, wArray));
        board[i][j] = ch;   // mark as unvisited
        return res;
    }
}

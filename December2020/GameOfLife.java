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
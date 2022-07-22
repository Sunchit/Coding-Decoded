// https://leetcode.com/problems/minesweeper/
// @author: anuj0503
class Solution {
    int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = board.length;
        int c = board[0].length;
        boolean[][] visited = new boolean[r][c];
        int clickRow = click[0];
        int clickCol = click[1];
        
        if(board[clickRow][clickCol] == 'M'){
            board[clickRow][clickCol] = 'X';
                return board;
        }
            
        updateBoardHelper(r, c, clickRow, clickCol, visited, board);
        
        return board;
    }
    
    private void updateBoardHelper(int r, int c, int clickRow, int clickCol, boolean[][] visited, char[][] board){
        
        if(board[clickRow][clickCol] == 'M') return;
        
        visited[clickRow][clickCol] = true;
        
        if(board[clickRow][clickCol] == 'E'){
            int count = 0;
            for(int[] dir : directions){
                int newClickRow = clickRow + dir[0];
                int newClickCol = clickCol + dir[1];
                
                if(newClickRow < 0 || newClickRow >= r || newClickCol < 0 || newClickCol >= c || visited[newClickRow][newClickCol] || board[newClickRow][newClickCol] == 'B') continue;
                
                if (board[newClickRow][newClickCol] == 'M')
                    count++;
            }
            
            if(count == 0){
                board[clickRow][clickCol] = 'B';
                
                for(int[] dir : directions){
                    int newClickRow = clickRow + dir[0];
                    int newClickCol = clickCol + dir[1];
                
                    if(newClickRow < 0 || newClickRow >= r || newClickCol < 0 || newClickCol >= c || visited[newClickRow][newClickCol] || board[newClickRow][newClickCol] == 'B') continue;
                
                if(board[newClickRow][newClickCol] == 'E')
                    updateBoardHelper(r, c, newClickRow, newClickCol, visited, board);
                }
            } else{
                board[clickRow][clickCol] = (char)(count + '0');
            }
        }
    }
}

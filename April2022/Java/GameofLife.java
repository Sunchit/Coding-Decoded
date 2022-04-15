// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public void gameOfLife(int[][] board) {
        int[][] ans=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int n=0;
                if(board[i][j]==1){
                    if(i-1>=0&&board[i-1][j]==1){
                        n++;
                    }
                    if(i+1<board.length&&board[i+1][j]==1){
                        n++;
                    }
                    if(j-1>=0&&board[i][j-1]==1){
                        n++;
                    }
                    if(j+1<board[0].length&&board[i][j+1]==1){
                        n++;
                    }
                    if(i-1>=0&&j-1>=0&&board[i-1][j-1]==1){
                        n++;
                    }
                    if(i+1<board.length&&j-1>=0&&board[i+1][j-1]==1){
                        n++;
                    }
                    if(i-1>=0&&j+1<board[0].length&&board[i-1][j+1]==1){
                        n++;
                    }
                    if(i+1<board.length&&j+1<board[0].length&&board[i+1][j+1]==1){
                        n++;
                    }
                    if(n<2||n>3){
                        ans[i][j]=0;
                    }else{
                        ans[i][j]=board[i][j];
                    }
                }else{
                     if(i-1>=0&&board[i-1][j]==1){
                        n++;
                    }
                    if(i+1<board.length&&board[i+1][j]==1){
                        n++;
                    }
                    if(j-1>=0&&board[i][j-1]==1){
                        n++;
                    }
                    if(j+1<board[0].length&&board[i][j+1]==1){
                        n++;
                    }
                    if(i-1>=0&&j-1>=0&&board[i-1][j-1]==1){
                        n++;
                    }
                    if(i+1<board.length&&j-1>=0&&board[i+1][j-1]==1){
                        n++;
                    }
                    if(i-1>=0&&j+1<board[0].length&&board[i-1][j+1]==1){
                        n++;
                    }
                    if(i+1<board.length&&j+1<board[0].length&&board[i+1][j+1]==1){
                        n++;
                    }
                    
                    if(n==3){
                        ans[i][j]=1;
                    }else{
                        ans[i][j]=board[i][j];
                    }
                }
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=ans[i][j];
            }
        }
    }
}
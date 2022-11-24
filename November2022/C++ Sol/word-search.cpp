class Solution {
private:
    bool findWord(vector<vector<char>>& board,vector<vector<int>>&visited,string &word, int row,int col,int len, int index){
        
        if(index==len){
            return true;
        }
        if(row<0 || col<0 || row>=board.size() || col>=board[0].size() || word[index] != board[row][col] || visited[row][col] == 1){
            return false;
        }
        visited[row][col] = 1;
        
        bool p1 = findWord(board,visited,word,row+1,col,len,index+1);
        bool p2 = findWord(board,visited,word,row-1,col,len,index+1);
        bool p3 = findWord(board,visited,word,row,col+1,len,index+1);
        bool p4 = findWord(board,visited,word,row,col-1,len,index+1);
        
        visited[row][col] = 0;
        
        return p1 || p2 || p3 || p4;
    }
public:
    bool exist(vector<vector<char>>& board, string word) {
        
        int len = word.size();
        
        int numRows = board.size();
        int numCols = board[0].size();
        
        for(int row = 0;row<numRows;row++){
            for(int col = 0;col<numCols;col++){
                if(board[row][col] == word[0]){
                    
                    vector<vector<int>>visited(numRows,vector<int>(numCols,0));
                    bool isPresent  = findWord(board,visited,word,row,col,len,0);
                    
                    if(isPresent){
                        return true;
                    }
                }
                
            }
        }
        
        
        return false;
    }
};
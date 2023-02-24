class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        map<int,vector<int>>m1;
        map<pair<int,int>,vector<int>>m2;
        
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[0].size();j++){
                if(board[i][j] == '.'){
                    continue;
                }
                int num = board[i][j] - '0';
           
                for(auto curr:m1[i+1]){
                    if(curr == num){

                        return false;
                    }
                }
                 for(auto curr:m1[-(j+1)]){
                     
                    if(curr == num){
                      
                        return false;
                    }
                }
                for(auto curr:m2[{i/3,j/3}]){
                    if(curr == num){
                        return false;
                    }
                }
                
                m1[i+1].push_back(num);
                m1[-(j+1)].push_back(num);
                m2[{i/3,j/3}].push_back(num);
            }
        }
        return true;
    }
};
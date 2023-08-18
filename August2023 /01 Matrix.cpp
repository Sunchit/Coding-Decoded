class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        queue<pair<int,int>> q;
        vector<vector<bool>> visited(mat.size(),vector<bool>(mat[0].size()));
        for(int i=0;i<mat.size();i++){
            for(int j=0;j<mat[0].size();j++){
                if(!mat[i][j]) q.push({i,j});
            }
        }
        vector<vector<int>> dir={{0,1},{0,-1},{1,0},{-1,0}};
        int level=0;
        while(q.size())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                int row=q.front().first;
                int col=q.front().second;
                mat[row][col]=level;
                q.pop();
                for(auto& i:dir){
                    row+=i[0];
                    col+=i[1];
                    if(!(col<0 || row<0 || col>=mat[0].size() || row>=mat.size() ||visited[row][col] || mat[row][col]==0))
                    {
                        visited[row][col]=true;
                        q.push({row,col});
                    }
                    row-=i[0];
                    col-=i[1];
                } 

            }
            level++;
        }
        return mat;
    }
};
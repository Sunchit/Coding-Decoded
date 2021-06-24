
// author - Shree lakshmi
// TC : o(maxMoves*m*n)
// SC: o(maxMoves*m*n)

class Solution {
public:
    int mod = 1000000007;
    int helper(int N, int m, int n,int moves, int x, int y, vector<vector<vector<int>>>& t){
        if(x<0||y<0||x>=m||y>=n)
            return 1;
        if(moves == N)
            return 0;
        if(t[moves][x][y]!=-1)
            return t[moves][x][y] % mod;
        int temp=0;
        temp = (temp+helper(N,m,n,moves+1,x,y-1,t))%mod; // moving left
        temp = (temp+helper(N,m,n,moves+1, x-1,y,t))%mod; //moving up
        temp = (temp+helper(N,m,n,moves+1, x+1, y,t))%mod; //moving below
        temp = (temp+helper(N,m,n,moves+1, x, y+1,t))%mod; // moving right
        t[moves][x][y] = temp;
        return t[moves][x][y]%mod;
    }
    int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        //storing -1 as when we reach maxMoves we will return 0
        vector<vector<vector<int>>> t(maxMove+1,vector<vector<int>>(m+1,vector<int>(n+1,-1)));
        t[maxMove][m][n] = helper(maxMove,m,n,0,startRow,startColumn,t);
        return t[maxMove][m][n] % mod;
    }
};
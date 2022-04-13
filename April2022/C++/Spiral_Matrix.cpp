class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> res(n,vector<int>(n,-1));
        int left_col=0,right_col=n-1,top_row=0,bottom_row=n-1,count=1;
        while(left_col<=right_col && top_row<=bottom_row)
        {
            for(int i=left_col;i<=right_col;i++)
                res[top_row][i]=count++;
            top_row++;
            for(int i=top_row;i<=bottom_row;i++)
                res[i][right_col]=count++;
            right_col--;
            for(int i=right_col;i>=left_col;i--)
                res[bottom_row][i]=count++;
            bottom_row--;
            for(int i=bottom_row;i>=top_row;i--)
                res[i][left_col]=count++;
            left_col++;
        }
        return res;
        
    }
};
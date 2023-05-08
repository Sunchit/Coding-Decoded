// Author: Mahesh Reddy B N
// Problem Link: https://leetcode.com/problems/matrix-diagonal-sum/description/

class Solution {
    public int diagonalSum(int[][] mat) {
        int ans = 0;
        int j =0;
        int k = mat.length-1;
        for(int i=0;i<mat.length;i++){
            ans+= mat[i][j];
            ans+=mat[k][i];
            if(i==k){
                ans-=mat[k][i];
            }
            k--;
            j++;
        }
        return ans;
    }
}
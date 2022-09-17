// https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/
// @author: anuj0503
class Solution {
    public int maxProduct(String str) {
        int n = str.length();
        int maxNum = 0, result = 0;
        
        for(int i = 0; i < n; i++){
            maxNum = maxNum | (1 << i);
        }
        
        for(int num = maxNum - 1; num > 0; num--){
            String f = "", s = "";
            for(int j = 0; j < n; j++){
                if((num & (1 << j)) != 0){
                    f = f + str.charAt(j);
                } else {
                    s = s + str.charAt(j);
                }
            }
            result = Math.max(result, LPS(s) * LPS(f));
        }
        return result;
    }
    
    private int LPS(String s){
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for(int i = 0; i < n; i++) dp[i][i] = 1;
        
        for(int len = 1; len < n; len++){
            for(int i = 0; i < n; i++){
                int j = len + i;
                
                if(j < n){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 2 + dp[i+1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                    }
                }
            }
        }
        
        return dp[0][n-1];
    }
}

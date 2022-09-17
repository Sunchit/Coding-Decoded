
// @saorav21994
// TC : O(n^2)
// SC : O(n^2)

class Solution {
    public int minDistance(String word1, String word2) {
        
        // find longest common subsequence between both strings and remove the count*2 from the combined length of both strings
        
        int l1 = word1.length();
        int l2 = word2.length();
        
        int [][] dp = new int[l1+1][l2+1];
        
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                char ch1 = word1.charAt(i-1);
                char ch2 = word2.charAt(j-1);
                
                if (ch1 == ch2)
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        
        int lcs = dp[l1][l2];
        
        int res = l1 + l2 - (2*lcs);
        
        return res;
        
        
    }
}

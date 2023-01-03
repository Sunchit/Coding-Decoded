class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
    
        // Get the length of each string
        int len1 = text1.length();
        int len2 = text2.length();
        
        // If the strings are the same, return the length of either string
        if(text1.equals(text2)){
            return len1;
        }

         // Initialize a 2D array for dynamic programming
        int[][] dp = new int[len1+1][len2+1];
        
        // Iterate through the strings
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                
                // If the characters at the current indices match
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    
                    / The length of the common subsequence increases by 1
                    dp[i][j] = dp[i-1][j-1] + 1;

                } else {
                    
                    // Otherwise, the length of the common subsequence does not change
                    // Take the maximum of the lengths of the common subsequences of the subproblems
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }

        // Return the length of the longest common subsequence
        return dp[len1][len2];
    }
}

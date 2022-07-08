
// @saorav21994
// TC : O(m*n)
// SC : O(m*n)

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int ls1 = s1.length();
        int ls2 = s2.length();
        if ((ls1+ls2) != s3.length()) return false;
        boolean [][]dp = new boolean[ls1+1][ls2+1]; // def initialized to False
        dp[0][0] = true;    // "", "" are interleaving
        for (int i = 1; i <= ls2; i++) {
            if (s2.charAt(i-1) == s3.charAt(i-1))
                dp[0][i] = dp[0][i-1];
        }
        for (int i = 1; i <= ls1; i++) {
            if (s1.charAt(i-1) == s3.charAt(i-1))
                dp[i][0] = dp[i-1][0];
        }
        for (int i = 1; i <= ls1; i++) {
            for (int j = 1; j <= ls2; j++) {
                if (s3.charAt(i+j-1) == s1.charAt(i-1))
                    dp[i][j] = dp[i-1][j];
                if (s3.charAt(i+j-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i][j] || dp[i][j-1];
            }
        }
        // for (int i = 0; i <)
        return dp[ls1][ls2];
    }
}

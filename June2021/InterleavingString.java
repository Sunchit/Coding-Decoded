class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        
        if ((len1+len2)!=len3) return false;

        boolean[][] dp = new boolean[len2+1][len1+1];

        dp[0][0] = true;

        for (int i = 1; i < dp[0].length; i++){
            dp[0][i] = dp[0][i-1]&&(s1.charAt(i-1)==s3.charAt(i-1));
        }

        for (int i = 1; i < dp.length; i++){
            dp[i][0] = dp[i-1][0]&&(s2.charAt(i-1)==s3.charAt(i-1));
        }

        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                dp[i][j] = (dp[i-1][j]&&(s2.charAt(i-1)==s3.charAt(i+j-1)))
                        || (dp[i][j-1]&&(s1.charAt(j-1)==s3.charAt(i+j-1)));
            }
        }

        return dp[len2][len1];
    }
}
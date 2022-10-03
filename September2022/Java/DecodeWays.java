
// @saorav21994

class Solution {
    public int numDecodings(String s) {
        
        // This represents a fibonacci sequence
        
        int l = s.length();
        int [] dp = new int[l+1];
        dp[0] = 1;
        dp[1] = 1;
        if (s.charAt(0) == '0') return 0;
        for (int i = 2; i <= l; i++) {
            dp[i] = 0;
            if (s.charAt(i-1) > '0') {
                dp[i] = dp[i-1];
            }
            if (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) < '7')) {
                dp[i] += dp[i-2];
            }
        }
        return dp[l];
    }
}

// https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/
// @author: @anuj0503
class Solution {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int result = 1;
        
        for(int i = 1; i < n; i++){
            if(s.charAt(i) != 'a' && s.charAt(i - 1) + 1 == s.charAt(i)){
                dp[i] = dp[i - 1] + 1;
                result = Math.max(result, dp[i]);
            }
        }
        
        return result;
    }
}

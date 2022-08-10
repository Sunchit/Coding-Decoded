// https://leetcode.com/problems/longest-ideal-subsequence/
// @author: anuj0503
class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] dp = new int[n];
        
        Arrays.fill(dp, 1);
        int result = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(Math.abs(s.charAt(j) - s.charAt(i)) <= k){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        
        return result;
    }
}

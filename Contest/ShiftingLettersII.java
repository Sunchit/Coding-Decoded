// https://leetcode.com/problems/shifting-letters-ii/
// @author: @anuj0503
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] dp = new int[n+5];

        for(int[] shift : shifts){
            int p1 = shift[0];
            int p2 = shift[1];
            int d = ((shift[2] == 0)?-1:1);

            dp[p1] += d;
            dp[p2 + 1] += (d*(-1));
        }

        for(int i = 1; i <= n; i++){
            dp[i] = dp[i] + dp[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int c = ((int)s.charAt(i) + dp[i]%26);

            if(c > 122){
                c = c%122;
                c += 96;
            } else if(c < 97){
                while(c < 97){
                    c += 26;
                }
            }

            sb.append((char)c);
        }

        return sb.toString();
    }
}


// @saorav21994
// TC : O(n)
// SC : O(1)

class Solution {
    public int scoreOfParentheses(String s) {
        int l = s.length();
        int count = 0;
        int res = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == '(')
                count += 1;
            else {
                count -= 1;
                if (s.charAt(i-1) == '(')
                    res += (int)Math.pow(2, count);
            }
        }
        return res;
    }
}

// @saorav21994

class Solution {
    public int calculate(String s) {
        int res = 0;
        int cur = 0;
        int sign = 1;
        Stack<Integer> st = new Stack<>();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == ' ') {
                continue;       // Do nothing
            }
            else if (Character.isDigit(s.charAt(i)) == true) {
                cur = s.charAt(i) - '0';
                while (i+1 < l && Character.isDigit(s.charAt(i+1)) == true) {
                    cur *= 10;
                    cur += s.charAt(i+1) - '0';
                    i += 1;
                }
                cur *= sign;
                res += cur;
                cur = 0;
                sign = 1;
            }
            else if (s.charAt(i) == '+') {
                sign = 1;
            }
            else if (s.charAt(i) == '-') {
                sign = -1;
            }
            else if (s.charAt(i) == '(') {
                st.push(res);
                res = 0;
                st.push(sign);
                sign = 1;
            }
            else {      // s.charAt(i) == ')'
                res *= st.pop();    // last sign
                res += st.pop();    // last value
            }
        }
        return res;
    }
}

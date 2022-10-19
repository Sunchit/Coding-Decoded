// @saorav21994

class Solution {
    
    public String calc(String s) {
        char ch = s.charAt(0);
        int count = 1;
        int l = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < l; i++) {
            if(s.charAt(i) != ch) {
                sb.append(count).append(ch);
                ch = s.charAt(i);
                count = 1;
            }
            else {
                count += 1;
            }
        }
        sb.append(count).append(ch);
        return sb.toString();
    }
    
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String res = "1";
        for (int i = 2; i <= n; i++) {
            res = calc(res);
        }
        return res;
    }
}

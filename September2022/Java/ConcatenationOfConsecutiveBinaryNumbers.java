
// @saorav21994

class Solution {
    public int concatenatedBinary(int n) {
        
        StringBuffer str = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            str.append(String.valueOf(Integer.toBinaryString(i)));
        }
        String s = String.valueOf(str);
        
        int modulo = 1000000007;
        int res = 1;
        int l = s.length();
        for (int i = 1; i < l; i++) {
            int next = (int)s.charAt(i)-48;
            res = ( res * 2 ) % modulo;
            res += next;
            res %= modulo;
        }
                
        return res;
        
    }
}

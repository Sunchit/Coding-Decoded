
// @saorav21994
// TC : O(lengthOfString)
// SC : O(1)

class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int l = s.length();
        char ch = s.charAt(l-1);
        if (ch == 'I') res += 1;
        else if (ch == 'V') res += 5;
        else if (ch == 'X') res += 10;
        else if (ch == 'L') res += 50;
        else if (ch == 'C') res += 100;
        else if (ch == 'D') res += 500;
        else if (ch == 'M') res += 1000;
        for (int i = l-2; i >= 0; i--) {
            ch = s.charAt(i);
            if (ch == 'M') res += 1000;
            else if (ch == 'D') {
                if (s.charAt(i+1) == 'M') res -= 500;
                else res += 500;
            }
            else if (ch == 'C') {
                if (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M') res -= 100;
                else res += 100;
            }
            else if (ch == 'L') {
                if (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M' || s.charAt(i+1) == 'C') res -= 50;
                else res += 50;
            }
            else if (ch == 'X') {
                if (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M' || s.charAt(i+1) == 'C' || s.charAt(i+1) == 'L') res -= 10;
                else res += 10;
            }
            else if (ch == 'V') {
                if (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M' || s.charAt(i+1) == 'C' || s.charAt(i+1) == 'L' || s.charAt(i+1) == 'X') res -= 5;
                else res += 5;
            }
            else if (ch == 'I') {
                if (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M' || s.charAt(i+1) == 'C' || s.charAt(i+1) == 'L' || s.charAt(i+1) == 'X' || s.charAt(i+1) == 'V') res -= 1;
                else res += 1;
            }
        }
        return res;
    }
}
